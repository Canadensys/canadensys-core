package net.canadensys.comparator;

import java.util.Comparator;
import net.canadensys.utils.StringUtils;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Null-safe unaccent String comparator
 * @author canadensys
 *
 */
public class UnaccentStringComparator implements Comparator<String>{
	@Override
	public int compare(String s1, String s2) {
		return ObjectUtils.compare(StringUtils.unaccent(s1),StringUtils.unaccent(s2));
	}
}