package net.canadensys.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This class is an 'extension' to java.util.Collections
 * @author canadensys
 *
 */
public class ListUtils {
	
	/**
	 * Check that a list allowing null and empty item contains at least one element that is
	 * not blank.
	 * @param list can't be null
	 * @return
	 */
	public static boolean containsAtLeastOneNonBlank(List<String> list){
		for(String str : list){
			if(StringUtils.isNotBlank(str)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Parse a list of String into a list of Integer.
	 * If one element can not be parsed, the behavior depends on the value of failOnException.
	 * @param strList can't be null
	 * @param failOnException if an element can not be parsed should we return null or add a null element to the list.
	 * @return list of all String parsed as Integer or null if failOnException
	 */
	public static List<Integer> toIntegerList(List<String> strList, boolean failOnException){
		List<Integer> intList = new ArrayList<Integer>();
		for(String str : strList){
			try{
				intList.add(Integer.parseInt(str));
			}
			catch(NumberFormatException nfe){
				if(failOnException){
					return null;
				}
				else{
					intList.add(null);
				}
			}
		}
		return intList;
	}

}
