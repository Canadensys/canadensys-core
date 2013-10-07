package net.canadensys.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for net.canadensys.utils.ArrayUtils
 * @author canandesys
 *
 */
public class ArrayUtilsTest {
	
	@Test
	public void testContainsNullRelated(){
		Object[] strArray = new String[]{"1","2","3"};
		
		assertTrue(ArrayUtils.containsOnlyNotNull(strArray));
		assertFalse(ArrayUtils.containsOnlyNull(strArray));

		strArray = new String[]{"1",null,"3"};
		assertFalse(ArrayUtils.containsOnlyNotNull(strArray));
		assertFalse(ArrayUtils.containsOnlyNull(strArray));
		
		strArray = new String[]{null,null,null};
		assertFalse(ArrayUtils.containsOnlyNotNull(strArray));
		assertTrue(ArrayUtils.containsOnlyNull(strArray));
	}
}
