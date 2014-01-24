package net.canadensys.utils;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * This test will zip a folder then, unzip it and compare the content.
 * @author canadensys
 *
 */
public class ZipUtilsTest {
	
	@Test
	public void testZipUnzipFolderContent(){
		try {
			File testFolder = new File(this.getClass().getResource("/ziptest").toURI());
			String testZipFilePath = testFolder.getParent()+ "/okapi.zip";
			//Zip the content folder
			assertTrue(ZipUtils.zipFolder(testFolder, testZipFilePath));
			File zippedFile = new File(testZipFilePath);
			assertTrue(zippedFile.exists());
			//Unzip the newly created file
			assertTrue(ZipUtils.unzipFileOrFolder(zippedFile,null));
			
			//compare content
			File testUnzippedFolder = new File(testFolder.getParent()+ "/okapi");
			for(File currFile : testUnzippedFolder.listFiles()){
				assertTrue(FileUtils.contentEquals(currFile, new File(testFolder.getAbsoluteFile() + "/" + currFile.getName())));
			}

			//clean up
			zippedFile.delete();
			FileUtils.deleteDirectory(testUnzippedFolder);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUnzipZipWithRootFolder(){
		try {
			File testFile = new File(this.getClass().getResource("/ziptest_folder/folder.zip").toURI());
			String testUnzipFolderPath = testFile.getParent()+ "/zip_content";
			File testUnzipFolder = new File(testUnzipFolderPath);
			
			//Unzip the file
			assertTrue(ZipUtils.unzipFileOrFolder(testFile, testUnzipFolderPath));

			//should contains 1 folder
			File[] content = testUnzipFolder.listFiles();
			assertTrue(content[0].exists() && content[0].isDirectory());
			
			//get the content of the folder
			content = content[0].listFiles();
			assertTrue(content.length > 0);
			
			//clean up
			FileUtils.deleteDirectory(testUnzipFolder);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testZipUnzipEnclosingFolder(){
		try {
			File testFolder = new File(this.getClass().getResource("/ziptest_folder/content_to_zip").toURI());
			String testZipFilePath = testFolder.getParent()+ "/zipWithFilesAndFolder.zip";
			//Zip the content folder
			assertTrue(ZipUtils.zipFolder(testFolder, testZipFilePath));
			File zippedFile = new File(testZipFilePath);
			assertTrue(zippedFile.exists());
			//Unzip the newly created file
			assertTrue(ZipUtils.unzipFileOrFolder(zippedFile,null));
			
			//compare content
			File testUnzippedFolder = new File(testFolder.getParent()+ "/zipWithFilesAndFolder");
			for(File currFile : testFolder.listFiles()){
				assertTrue(new File(testUnzippedFolder.getAbsoluteFile() + "/" + currFile.getName()).exists());
			}

			//clean up
			zippedFile.delete();
			FileUtils.deleteDirectory(testUnzippedFolder);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
