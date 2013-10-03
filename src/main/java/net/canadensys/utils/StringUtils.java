package net.canadensys.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Utility functions related to String class
 * This class is an 'extension' to Apache StringUtils
 * @author canadensys
 *
 */
public class StringUtils {
	private static final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	
	/**
	 * Make all elements of a String array upper case.
	 * @param strings string array, may contain null item
	 * @return array containing all provided elements upper case
	 */
	public static String[] allUpperCase(String... strings){
		String[] tmp = new String[strings.length];
		for(int idx=0;idx<strings.length;idx++){
			if(strings[idx] != null){
				tmp[idx] = strings[idx].toUpperCase();
			}
		}
		return tmp;
	}
	
	/**
	 * Make all elements of a String array lower case.
	 * @param strings string array, may contain null item
	 * @return array containing all provided elements lower case
	 */
	public static String[] allLowerCase(String... strings){
		String[] tmp = new String[strings.length];
		for(int idx=0;idx<strings.length;idx++){
			if(strings[idx] != null){
				tmp[idx] = strings[idx].toLowerCase();
			}
		}
		return tmp;
	}
	
	@Deprecated
	/**
	 * @deprecated use org.apache.commons.lang3.StringUtils.stripAccents(str)
	 * Removes all accents on characters in a String.
	 * éàû will return eau
	 * @param s
	 * @return provided String without accent
	 */
	public static String unaccent(String s) {
		if(s == null){
			return null;
		}
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		return pattern.matcher(temp).replaceAll("");
	}
}
