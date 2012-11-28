package net.canadensys.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Test class for net.canadensys.lang.RomanNumeral
 * @author canadenys
 *
 */
public class RomanNumeralTest {
	
	@Test
	public void testRomanNumeral(){
		//even if MDCCCCX is considered valid by some, we do not consider it valid.
		assertEquals(1910, new RomanNumeral("MCMX").toInt());
		assertEquals(99, new RomanNumeral("XCIX").toInt());
		assertEquals(38, new RomanNumeral("XXXVIII").toInt());
		assertEquals(50, new RomanNumeral("L").toInt());
		assertEquals(1988, new RomanNumeral("MCMLXXXVIII").toInt());
		assertEquals(6, new RomanNumeral("VI").toInt());
		
		//test bounds
		assertEquals(1, new RomanNumeral("I").toInt());
		assertEquals(3999, new RomanNumeral("MMMCMXCIX").toInt());
		
		assertEquals("MCMX", new RomanNumeral(1910).toRomanNumeral());
		assertEquals("XCIX", new RomanNumeral(99).toRomanNumeral());
		assertEquals("XXXVIII", new RomanNumeral(38).toRomanNumeral());
		assertEquals("L", new RomanNumeral(50).toRomanNumeral());
		assertEquals("MCMLXXXVIII", new RomanNumeral(1988).toRomanNumeral());
		assertEquals("VI", new RomanNumeral(6).toRomanNumeral());
		//test bounds
		assertEquals("I", new RomanNumeral(1).toRomanNumeral());
		assertEquals("MMMCMXCIX", new RomanNumeral(3999).toRomanNumeral());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testRomanNumeralZero(){
		new RomanNumeral(0);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testRomanNumeralNegative(){
		new RomanNumeral(-4);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testRomanNumeralMax(){
		new RomanNumeral(4000);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testRomanNumeralInvalid1(){
		new RomanNumeral("IL");
	}
	
	@Test
	public void testEquals(){
		assertEquals(new RomanNumeral(1988), new RomanNumeral(1988));
		assertEquals(new RomanNumeral("VI"), new RomanNumeral(6));
		assertFalse(new RomanNumeral(6).equals(new Integer(6)));
	}
	
	@Test
	public void testCompare(){
		List<RomanNumeral> testList = new ArrayList<RomanNumeral>();
		testList.add(new RomanNumeral("MCMX")); //1910
		testList.add(new RomanNumeral("XCIX"));//99
		testList.add(new RomanNumeral("XXXVIII"));//38
		
		Collections.sort(testList);
		assertEquals(38, testList.get(0).toInt());
		assertEquals(99, testList.get(1).toInt());
		assertEquals(1910, testList.get(2).toInt());
	}
}
