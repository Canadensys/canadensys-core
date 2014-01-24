package net.canadensys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * Utility class regrouping zip file management functions.
 * @author canadensys
 *
 */
public class ZipUtils {
	
	public static final String ZIP_EXT = "." + ArchiveStreamFactory.ZIP;

	/**
	 * Utility function to zip the content of an entire folder, but not the folder itself.
	 * @param folder
	 * @param fileName optional
	 * @return success or not
	 */
	public static boolean zipFolder(File folder, String fileName){
		boolean success = false;
		if(!folder.isDirectory()){
			return false;
		}
		
		if(fileName == null){
			fileName = folder.getAbsolutePath()+ZIP_EXT;
		}
		
		ZipArchiveOutputStream zipOutput = null;
		try {
			zipOutput = new ZipArchiveOutputStream(new File(fileName));
			
			success = addFolderContentToZip(folder,zipOutput,"");

			zipOutput.close();
		
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				if(zipOutput != null){
					zipOutput.close();
				}
			} catch (IOException e) {}
		}
		return success;
	}
	
	/**
	 * Add the content of a folder to the zip.
	 * If this folder also contains folder(s), this function is called recursively.
	 * @param folder
	 * @param zipOutput
	 * @param folderFromRoot relative path (from archive root) of this folder.
	 * @return
	 */
	private static boolean addFolderContentToZip(File folder, ZipArchiveOutputStream zipOutput, String folderFromRoot){
		FileInputStream fileInput;
		try{
			for(File currFile : folder.listFiles()){
				ZipArchiveEntry entry = null;
				if(currFile.isDirectory()){
					//as defined by ZipArchiveEntry:
					//Assumes the entry represents a directory if and only if the name ends with a forward slash "/".
					entry = new ZipArchiveEntry(folderFromRoot+currFile.getName()+"/");
					zipOutput.putArchiveEntry(entry);
					zipOutput.closeArchiveEntry();
					//now look for the content of this directory
					if(!addFolderContentToZip(currFile,zipOutput,folderFromRoot+currFile.getName()+"/")){
						return false;
					}
				}
				else{
					entry = new ZipArchiveEntry(folderFromRoot+currFile.getName());
					entry.setSize(currFile.length());
					zipOutput.putArchiveEntry(entry);
					
					fileInput = new FileInputStream(currFile);
					IOUtils.copy(fileInput, zipOutput);
					fileInput.close();
					zipOutput.closeArchiveEntry();
				}
			}
		}catch(FileNotFoundException fnfEx){
			fnfEx.printStackTrace();
			return false;
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Unzip a file or a folder
	 * @param zipFile
	 * @param unzippedFolder optional, if null the file/folder will be extracted in the same folder as zipFile
	 * @return
	 */
	public static boolean unzipFileOrFolder(File zipFile, String unzippedFolder){
		InputStream is;
		ArchiveInputStream in = null;
		OutputStream out  = null;
		
		if(!zipFile.isFile()){
			return false;
		}
		
		if(unzippedFolder == null){
			unzippedFolder = FilenameUtils.removeExtension(zipFile.getAbsolutePath());
		}
		try {
			is = new FileInputStream(zipFile);
			new File(unzippedFolder).mkdir();
			
			in = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, is);
			
			ZipArchiveEntry entry = (ZipArchiveEntry)in.getNextEntry();
			while(entry != null){
				if(entry.isDirectory()){
					new File(unzippedFolder,entry.getName()).mkdir();
				}
				else{
					out = new FileOutputStream(new File(unzippedFolder, entry.getName()));
					IOUtils.copy(in, out);
					out.close();
					out = null;
				}
				entry = (ZipArchiveEntry)in.getNextEntry();
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (ArchiveException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {}
			}
		}
		return true;
	}
}