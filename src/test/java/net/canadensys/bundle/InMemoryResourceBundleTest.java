package net.canadensys.bundle;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Test;

/**
 * Test class for net.canadensys.bundle.InMemoryResourceBundle
 * @author canadensys
 *
 */
public class InMemoryResourceBundleTest {
	
	@Test
	public void testBundleLookup(){
		InMemoryResourceBundle frBundle = InMemoryResourceBundle.getBundle("bundle.bundle", Locale.FRENCH);
		
		assertEquals("house", frBundle.lookup("Maison"));
		assertEquals("Maison", frBundle.inverseLookup("house"));
		
		//test case insensitive lookup
		InMemoryResourceBundle enBundle = InMemoryResourceBundle.getBundle("bundle.bundle", Locale.ENGLISH, false);
		assertEquals("house", enBundle.lookup("house"));
		
		//test ascii folding lookup
		frBundle = InMemoryResourceBundle.getBundle("bundle.bundle", Locale.FRENCH, false, true);
		assertEquals("state", frBundle.lookup("etat"));
	}
	
	@Test(expected = MissingResourceException.class)
	public void testBundleNotFound(){
		InMemoryResourceBundle.getBundle("bundle.nobundle", Locale.ENGLISH);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBundleNonUniqueValue(){
		InMemoryResourceBundle.getBundle("bundle.badvaluebundle", Locale.ENGLISH);
	}

}
