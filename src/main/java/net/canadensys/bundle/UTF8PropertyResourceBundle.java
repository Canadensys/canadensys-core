package net.canadensys.bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * PropertyResourceBundle able to read an UTF-8 properties file.
 * @author cgendreau
 *
 */
public class UTF8PropertyResourceBundle {
	private static final String PROPERTIES_EXT = ".properties";
	
	/**
	 * Get a PropertyResourceBundle able to read an UTF-8 properties file.
	 * @param baseName
	 * @param locale
	 * @return new ResourceBundle or null if no bundle can be found.
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static PropertyResourceBundle getBundle(String baseName, Locale locale) throws UnsupportedEncodingException, IOException{
		ResourceBundle rs = null;
		try{
			rs = ResourceBundle.getBundle(baseName, locale, ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT));
		}
		catch(MissingResourceException mrEx){
			return null;
		}
		//get the name from ResourceBundle to accommodate different combinations of language/country.
		String foundLocale = rs.getLocale().toString();
		InputStream is = UTF8PropertyResourceBundle.class.getResourceAsStream("/"+baseName + "_"+foundLocale.toString()+PROPERTIES_EXT);
		if(is != null){
			return new PropertyResourceBundle(new InputStreamReader(is, "UTF-8"));
		}
		return null;
	}
}
