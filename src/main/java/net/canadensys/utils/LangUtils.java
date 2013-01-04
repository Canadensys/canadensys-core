package net.canadensys.utils;

import java.lang.annotation.Annotation;

/**
 * Utility functions related to Java language
 * @author canadensys
 *
 */
public class LangUtils {
	
	/**
	 * Get the value of a Annotation in a class declaration.
	 * @param classType
	 * @param annotationType
	 * @param attributeName
	 * @return the value of the annotation as String or null if something goes wrong
	 */
	public static <T, A extends Annotation> String getClassAnnotationValue(Class<T> classType, Class<A> annotationType, String attributeName) {
		String value = null;
		Annotation annotation = classType.getAnnotation(annotationType);
		if (annotation != null) {
			try {
				value = (String) annotation.annotationType().getMethod(attributeName).invoke(annotation);
			} catch (Exception ex) {}
		}
		return value;
	}
}
