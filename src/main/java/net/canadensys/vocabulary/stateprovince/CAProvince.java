package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
 * @Deprecated this should be maintained in a dictionary file.
 * https://github.com/WingLongitude/shared-dictionaries/blob/master/src/main/resources/dictionaries/geography/CA_ISO3166-2.txt
 * 
 * Enumeration representing the Canadian provinces and territories
 * TODO : override valueOf(String)
 * @author canadensys
 * 
 * Source:
 * http://en.wikipedia.org/wiki/ISO_3166-2:CA
 *
 */
@Deprecated
public enum CAProvince implements StateProvinceEnum{
	//Provinces
	ALBERTA("CA-AB","Alberta"),
	BRITISH_COLUMBIA("CA-BC","British Columbia"),
	MANITOBA("CA-MB","Manitoba"),
	NEW_BRUNSWICK("CA-NB","New Brunswick"),
	NEWFOUNDLAND_AND_LABRADOR("CA-NL","Newfoundland and Labrador"),
	NOVA_SCOTIA("CA-NS","Nova Scotia"),
	ONTARIO("CA-ON","Ontario"),
	PRINCE_EDWARD_ISLAND("CA-PE","Prince Edward Island"),
	QUEBEC("CA-QC","Québec"),
	SASKATCHEWAN("CA-SK","Saskatchewan"),
	//Territories
	NORTHWEST_TERRITORIES("CA-NT","Northwest Territories"),
	NUNAVUT("CA-NU","Nunavut"),
	YUKON("CA-YT","Yukon");
	
	private final String provinceCode;
	private final String provinceName;

	private CAProvince(String provinceCode, String provinceName) {
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
	public static CAProvince fromCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (CAProvince p : CAProvince.values()){
				if (codeUpper.equals(p.provinceCode)){
					return p;
				}
			}
		}
		return null;
	}
}

