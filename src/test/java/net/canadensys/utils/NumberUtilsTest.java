package net.canadensys.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for net.canadensys.utils.NumberUtils
 * @author canandesys
 *
 */
public class NumberUtilsTest {
	
	@Test
	public void testParseNumber(){
		assertEquals(new Integer("532"), NumberUtils.parseNumber("532", Integer.class));
		assertEquals(new Float("8.32"), NumberUtils.parseNumber("8.32", Float.class));
		assertEquals(new Float("-128.32"), NumberUtils.parseNumber("-128.32", Float.class));
		assertEquals(new Double("3.14159"), NumberUtils.parseNumber("3.14159", Double.class));
		assertEquals(new Short("33"), NumberUtils.parseNumber("33", Short.class));
		assertEquals(new Long("123456789"), NumberUtils.parseNumber("123456789", Long.class));
		assertEquals(new Byte("0"), NumberUtils.parseNumber("0", Byte.class));
		assertNull(NumberUtils.parseNumber("0.3", Integer.class));
		assertNull(NumberUtils.parseNumber(null, Integer.class));
		//null is not handled the same way in Integer than in Double class
		assertNull(NumberUtils.parseNumber(null, Double.class));
	}
}
