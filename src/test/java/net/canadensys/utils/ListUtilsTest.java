package net.canadensys.utils;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Test class for net.canadensys.utils.ListUtils
 * @author canandesys
 *
 */
public class ListUtilsTest {
	
	@Test
	public void testToIntegerList(){
		List<String> strList = Arrays.asList(new String[]{"1","2","3"});
		List<Integer> intList = ListUtils.toIntegerList(strList,false);
		
		assertEquals(1,intList.get(0).intValue());
		assertEquals(2,intList.get(1).intValue());
		assertEquals(3,intList.get(2).intValue());
		
		//test failOnException
		strList = Arrays.asList(new String[]{"1","test","3"});
		intList = ListUtils.toIntegerList(strList,false);
		assertEquals(1,intList.get(0).intValue());
		assertNull(intList.get(1));
		assertEquals(3,intList.get(2).intValue());
		
		strList = Arrays.asList(new String[]{"1","test","3"});
		intList = ListUtils.toIntegerList(strList,true);
		assertNull(intList);
	}
	
	@Test
	public void testContainsAtLeastOneNonBlank(){
		List<String> strList1 = Arrays.asList(new String[]{null,"test",null});
		List<String> strList2 = Arrays.asList(new String[]{null,null,null});
		assertTrue(ListUtils.containsAtLeastOneNonBlank(strList1));
		assertFalse(ListUtils.containsAtLeastOneNonBlank(strList2));
	}
}
