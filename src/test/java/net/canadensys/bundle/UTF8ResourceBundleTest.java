package net.canadensys.bundle;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class UTF8ResourceBundleTest {
	
	@Test
	public void testUTF8Bundle(){
		ResourceBundle bundle = null;
		
		//load UTF-8 bundle with ResourceBundle.getBundle
		bundle = ResourceBundle.getBundle("bundle/bundleutf8", Locale.FRENCH);
		//it should not be what we want
		assertTrue(!"état".equals(bundle.getString("state")));
		
		//try with UTF8ResourceBundle
		try {
			bundle = UTF8PropertyResourceBundle.getBundle("bundle/bundleutf8", Locale.FRENCH);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals("état",bundle.getString("state"));
	}

}
