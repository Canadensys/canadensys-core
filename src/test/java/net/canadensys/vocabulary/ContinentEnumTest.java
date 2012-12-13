package net.canadensys.vocabulary;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for net.canadensys.vocabulary.Continent enum
 * @author canandesys
 *
 */
public class ContinentEnumTest {
	@Test
	public void testEnum(){
		assertNull(Continent.fromCode(null));
		assertNull(Continent.fromCode(""));
		assertNull(Continent.fromCode("test"));
		assertEquals(Continent.AFRICA, Continent.fromCode("AF"));
		assertEquals(Continent.AFRICA, Continent.fromCode("af"));
	}
}
