package net.canadensys.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for net.canadensys.utils.StringUtils
 * @author canandesys
 *
 */
public class StringUtilsTest {
	
	@Test
	public void testUnaccent(){
		assertTrue("j'aime les eacu.Ona".equals(StringUtils.unaccent("j'aime les éàçû.Ôñá")));
		
		//test alternative
		assertTrue("j'aime les eacu.Ona".equals(org.apache.commons.lang3.StringUtils.stripAccents("j'aime les éàçû.Ôñá")));
	}
	
	@Test
	public void testUnaccentNull(){
		assertNull(StringUtils.unaccent(null));
		//test alternative
		assertNull(org.apache.commons.lang3.StringUtils.stripAccents(null));
	}
	
	@Test
	public void testAllLowerCase(){
		String[] strs = new String[]{"this","IS","a Test"};
		String[] strsUc = StringUtils.allLowerCase(strs);
		
		assertEquals("this",strsUc[0]);
		assertEquals("is",strsUc[1]);
		assertEquals("a test",strsUc[2]);	
	}
	
	@Test
	public void testAllUpperCase(){
		String[] strs = new String[]{"this","IS","a Test"};
		String[] strsUc = StringUtils.allUpperCase(strs);
		
		assertEquals("THIS",strsUc[0]);
		assertEquals("IS",strsUc[1]);
		assertEquals("A TEST",strsUc[2]);
	}
}
