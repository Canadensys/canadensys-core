package net.canadensys.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * The the behavior of UTF8PropertyResourceBundle
 * @author cgendreau
 *
 */
public class UTF8ResourceBundleTest {
	
	@Test
	public void testUTF8Bundle(){
		ResourceBundle bundle = null;
		
		//load UTF-8 bundle with ResourceBundle.getBundle
		bundle = ResourceBundle.getBundle("bundle/bundleutf8", Locale.FRENCH);
		//it should not be what we want
		assertTrue(!"état".equals(bundle.getString("state")));
		
		//try with UTF8ResourceBundle
		bundle = getUTF8Bundle(Locale.FRENCH);
		assertEquals("état",bundle.getString("state"));
	}
	
	/**
	 * Non existing Locale should return null
	 */
	@Test
	public void testUTF8NonExistingBundle(){
		// non existing language
		ResourceBundle bundle = getUTF8Bundle(new Locale("zz"));
		assertNull(bundle);
		
		// language only but our bundle is called (en-CA) so English only is not precise enough and null should be returned.
		bundle = getUTF8Bundle(Locale.ENGLISH);
		assertNull(bundle);
	}
	
	/**
	 * Test with the language and country code
	 */
	@Test
	public void testUTF8BundleWithCountryCode(){
		// country code and language with our bundle named (fr)
		ResourceBundle bundle = getUTF8Bundle(Locale.CANADA_FRENCH);
		assertEquals("état",bundle.getString("state"));
	}
	
	/**
	 * Helper function that wraps the exceptions for code readability.
	 * @param locale
	 * @return
	 */
	private ResourceBundle getUTF8Bundle(Locale locale){
		ResourceBundle bundle = null;
		
		try {
			bundle = UTF8PropertyResourceBundle.getBundle("bundle/bundleutf8", locale);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail();
		}
		catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		return bundle;
	}
}
