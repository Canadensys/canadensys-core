package net.canadensys.utils;

/**
 * Utility functions related to Number class
 * @author canadensys
 *
 */
public class NumberUtils {
	
	/**
	 * Tries to parse value into the targetClass.
	 * The implementation is no elegant, but it's faster than
	 * targetClass.getConstructor(String.class).newInstance(value);
	 * @param value
	 * @param targetClass
	 * @return T instance of value or null if the parsing failed
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseNumber(String value, Class<T> targetClass){
		if(value == null){
			return null;
		}
		try{
			if(Integer.class == targetClass){
				return (T)Integer.valueOf(value);
			}
			else if(Float.class == targetClass){
				return (T)Float.valueOf(value);
			}
			else if(Double.class == targetClass){
				return (T)Double.valueOf(value);
			}
			else if(Byte.class == targetClass){
				return (T)Byte.valueOf(value);
			}
			else if(Short.class == targetClass){
				return (T)Short.valueOf(value);
			}
			else if(Long.class == targetClass){
				return (T)Long.valueOf(value);
			}
			else{
				return null;
			}
		}
		catch(NumberFormatException e){}
		return null;
	}

}
