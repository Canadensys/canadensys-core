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
	 * Utility function to zip an entire folder.
	 * @param folder
	 * @param fileName optional
	 * @return success or not
	 */
	public static boolean zipFolder(File folder, String fileName){
		
		if(!folder.isDirectory()){
			return false;
		}
		
		if(fileName == null){
			fileName = folder.getAbsolutePath()+ZIP_EXT;
		}
		
		ZipArchiveOutputStream zipOutput;
		FileInputStream fileInput;
		try {
			zipOutput = new ZipArchiveOutputStream(new File(fileName));
			for(File currFile : folder.listFiles()){
				ZipArchiveEntry entry = new ZipArchiveEntry(currFile.getName());
				entry.setSize(currFile.length());
				zipOutput.putArchiveEntry(entry);
				fileInput = new FileInputStream(currFile);
				IOUtils.copy(fileInput, zipOutput);
				zipOutput.closeArchiveEntry();
				fileInput.close();
			}
			zipOutput.close();
		
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean unzipFileOrFolder(File zipFilePath, String unzippedFolder){
		InputStream is;
		ArchiveInputStream in = null;
		OutputStream out  = null;
		
		if(!zipFilePath.isFile()){
			return false;
		}
		
		if(unzippedFolder == null){
			unzippedFolder = FilenameUtils.removeExtension(zipFilePath.getAbsolutePath());
		}
		try {
			is = new FileInputStream(zipFilePath);
			new File(unzippedFolder).mkdir();
			
			in = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, is);
			
			ZipArchiveEntry entry = (ZipArchiveEntry)in.getNextEntry();
			while(entry != null){
				out = new FileOutputStream(new File(unzippedFolder, entry.getName()));
				IOUtils.copy(in, out);
				out.close();
				out = null;
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