package net.canadensys.utils;

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
	}
	
	@Test
	public void testUnaccentNull(){
		assertNull(StringUtils.unaccent(null));
	}
}
