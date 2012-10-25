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
