package net.canadensys.utils;


/**
 * Utility functions related to array.
 * This class is an 'extension' to java.util.Arrays and org.apache.commons.lang3.ArrayUtils
 * @author canadensys
 *
 */
public class ArrayUtils {
	
	/**
	 * Check that an array only contains null elements.
	 * @param values, can't be null
	 * @return
	 */
	public static boolean containsOnlyNull(Object... values){	
		for(Object o : values){
			if(o!= null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check that an array only contains elements that are not null.
	 * @param values, can't be null
	 * @return
	 */
	public static boolean containsOnlyNotNull(Object... values){	
		for(Object o : values){
			if(o== null){
				return false;
			}
		}
		return true;
	}
}
