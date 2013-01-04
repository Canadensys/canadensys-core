package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
 * Enumeration representing the Canadian provinces and territories
 * TODO : override valueOf(String)
 * @author canadensys
 *
 */
public enum CanadaProvince implements StateProvinceEnum{
	//Provinces
	ALBERTA("AB","Alberta"),
	BRITISH_COLUMBIA("BC","British Columbia"),
	MANITOBA("MB","Manitoba"),
	NEW_BRUNSWICK("NB","New Brunswick"),
	NEWFOUNDLAND_AND_LABRADOR("NL","Newfoundland and Labrador"),
	NOVA_SCOTIA("NS","Nova Scotia"),
	ONTARIO("ON","Ontario"),
	PRINCE_EDWARD_ISLAND("PE","Prince Edward Island"),
	QUEBEC("QC","Québec"),
	SASKATCHEWAN("SK","Saskatchewan"),
	//Territories
	NORTHWEST_TERRITORIES("NT","Northwest Territories"),
	NUNAVUT("NU","Nunavut"),
	YUKON("YT","Yukon");
	
	private final String provinceCode;
	private final String provinceName;

	private CanadaProvince(String provinceCode, String provinceName) {
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}
	
	@Override
	public String getCode(){
		return provinceCode;
	}
	
	@Override
	public String getName(){
		return provinceName;
	}
	
	/**
	 * Get the enumeration element from the state code.
	 * @param code
	 * @return the matching enumeration element or null if the code could not be found.
	 */
	public static CanadaProvince fromCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (CanadaProvince p : CanadaProvince.values()){
				if (codeUpper.equals(p.provinceCode)){
					return p;
				}
			}
		}
		return null;
	}
}

