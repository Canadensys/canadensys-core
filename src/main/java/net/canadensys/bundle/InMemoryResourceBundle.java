package net.canadensys.bundle;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * ResourceBundle loaded as a in-memory map with inverse lookup support.
 * Due to inverse lookup support, all keys must be unique but also all values.
 * You should only use this class for small resource bundle since it will all be loaded in memory.
 * @author canadensys
 *
 */
public class InMemoryResourceBundle {

	private Map<String, String> lookup;
	private Map<String, String> inverseLookup;
	
	private boolean caseSensitiveLookup = true;
	private boolean asciiFoldingLookup = false;
	
	private InMemoryResourceBundle(String baseName, Locale locale, boolean caseSensitiveLookup, boolean asciiFoldingLookup) throws MissingResourceException, IllegalArgumentException {
		this.caseSensitiveLookup = caseSensitiveLookup;
		this.asciiFoldingLookup = asciiFoldingLookup;
		initBundle(baseName, locale);
	}
	
	public static InMemoryResourceBundle getBundle(String baseName, Locale locale) throws MissingResourceException, IllegalArgumentException{
		return new InMemoryResourceBundle(baseName, locale, true, false);
	}
	
	public static InMemoryResourceBundle getBundle(String baseName, Locale locale, boolean caseSensitiveLookup) throws MissingResourceException, IllegalArgumentException{
		return new InMemoryResourceBundle(baseName, locale, caseSensitiveLookup, false);
	}
	
	/**
	 * Get a new InMemoryResourceBundle instance.
	 * @param baseName
	 * @param locale
	 * @param caseSensitiveLookup Should the lookup be case sensitive or not.
	 * @param asciiFoldingLookup Should ascii folding be apply? so key like 'allô' will will be found if 'allo' is provided.
	 * @return
	 * @throws MissingResourceException if no bundle can be loaded from the baseName 
	 * @throws IllegalArgumentException if values are not unique within the file
	 */
	public static InMemoryResourceBundle getBundle(String baseName, Locale locale, boolean caseSensitiveLookup, boolean asciiFoldingLookup) throws MissingResourceException, IllegalArgumentException{
		return new InMemoryResourceBundle(baseName, locale, caseSensitiveLookup, asciiFoldingLookup);
	}
	
	private void initBundle(String baseName, Locale locale) throws IllegalArgumentException{
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
		lookup = new HashMap<String, String>();
		inverseLookup = new HashMap<String, String>();
		
		Enumeration<String> keys = bundle.getKeys();
		String key;
		String value;
		
		while(keys.hasMoreElements()){
			key = keys.nextElement();
			value = bundle.getString(key);
			
			//since the value now becomes a key, it must be unique.
			if(inverseLookup.containsKey(value)){
				//empty map
				lookup.clear();
				inverseLookup.clear();
				throw new IllegalArgumentException("InMemoryResourceBundle lookup creation failed. Keys AND values must be unique.");
			}
			lookup.put(formatKey(key), value);
			inverseLookup.put(formatKey(value), key);
		}
		//discard resource bundle;
		bundle = null;
	}
	
	private String formatKey(String key){
		if(!caseSensitiveLookup){
			key = key.toLowerCase();
		}
		if(asciiFoldingLookup){
			key = StringUtils.stripAccents(key);
		}
		return key;
	}
	
	/**
	 * Do a lookup on the bundle.
	 * @param key as defined in the bundle file
	 * @return the value associated with this key
	 */
	public String lookup(String key){
		return lookup.get(formatKey(key));
	}
	
	/**
	 * Do a inverse lookup on the bundle.
	 * @param value as defined in the bundle file
	 * @return the key associated with this value
	 */
	public String inverseLookup(String value){
		return inverseLookup.get(formatKey(value));
	}
}
