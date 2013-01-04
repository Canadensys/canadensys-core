package net.canadensys.vocabulary.stateprovince;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for net.canadensys.vocabulary.stateprovince.USState enum
 * @author canandesys
 *
 */
public class USStateEnumTest {
	
	@Test
	public void testEnum(){
		assertNull(USState.fromCode(null));
		assertNull(USState.fromCode(""));
		assertNull(USState.fromCode("test"));
		assertEquals(USState.DELAWARE, USState.fromCode("DE"));
		assertEquals(USState.DELAWARE, USState.fromCode("de"));
	}
}
