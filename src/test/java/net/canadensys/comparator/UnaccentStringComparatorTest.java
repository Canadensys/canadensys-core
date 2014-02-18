package net.canadensys.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Test class for net.canadensys.comparator.UnaccentStringComparator
 * @author canadensys
 *
 */
public class UnaccentStringComparatorTest {
	
	@Test
	public void testComparator(){
		List<String> testList = new ArrayList<String>();
		testList.add("zoo");
		testList.add("étang");
		testList.add(null);
		testList.add("ethan");
		
		Collections.sort(testList, new UnaccentStringComparator());
		
		assertNull(testList.get(0));
		assertEquals("étang",testList.get(1));
		assertEquals("ethan",testList.get(2));
		assertEquals("zoo",testList.get(3));
	}
}
