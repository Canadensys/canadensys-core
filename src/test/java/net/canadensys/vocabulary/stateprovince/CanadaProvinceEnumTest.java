package net.canadensys.vocabulary.stateprovince;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for net.canadensys.vocabulary.stateprovince.CanadaProvince enum
 * @author canandesys
 *
 */
public class CanadaProvinceEnumTest {
	@Test
	public void testEnum(){
		assertNull(CanadaProvince.fromProvinceCode(null));
		assertNull(CanadaProvince.fromProvinceCode(""));
		assertNull(CanadaProvince.fromProvinceCode("test"));
		assertEquals(CanadaProvince.MANITOBA, CanadaProvince.fromProvinceCode("MB"));
		assertEquals(CanadaProvince.MANITOBA, CanadaProvince.fromProvinceCode("mb"));
	}
}
