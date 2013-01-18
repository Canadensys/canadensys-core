package net.canadensys.vocabulary.stateprovince;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Generic test class for net.canadensys.vocabulary.stateprovince.* enum
 * To test a new enum add it to the static{} block.
 * @author canandesys
 *
 */
public class StateProvinceEnumTest {
	
	private static List<Class<? extends StateProvinceEnum>> enumToTest = new ArrayList<Class<? extends StateProvinceEnum>>();
	
	//list of all StateProvince to test
	static{
		enumToTest.add(CanadaProvince.class);
		enumToTest.add(USState.class);
	}
	
	@Test
	public void testEnum(){
		Method fromCodeMethod;
		try {
			for(Class<? extends StateProvinceEnum> clazz : enumToTest){
				assertTrue(clazz.isEnum());
				
				fromCodeMethod = clazz.getMethod("fromCode", String.class);
				//test that null is returned
				assertNull(fromCodeMethod.invoke(null,(Object)null));
				assertNull(fromCodeMethod.invoke(null,""));
				assertNull(fromCodeMethod.invoke(null,"-test-"));
				
				//test the first element
				StateProvinceEnum[] enumConstants = clazz.getEnumConstants();
				StateProvinceEnum val0 = enumConstants[0];
				assertEquals(val0, fromCodeMethod.invoke(null,val0.getCode().toLowerCase()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
