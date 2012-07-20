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
	public void testZipFolder(){
		try {
			File testFolder = new File(this.getClass().getResource("/ziptest").toURI());
			String testZipFilePath = testFolder.getParent()+ "/okapi.zip";
			//Zip the folder
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
}
