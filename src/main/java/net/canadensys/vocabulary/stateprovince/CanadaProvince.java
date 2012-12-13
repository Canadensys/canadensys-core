package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

public enum CanadaProvince {
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
	private final String provinceTitle;

	private CanadaProvince(String provinceCode, String provinceTitle) {
		this.provinceCode = provinceCode;
		this.provinceTitle = provinceTitle;
	}
	
	public String getProvinceCode(){
		return provinceCode;
	}
	
	public String getProvinceTitle(){
		return provinceTitle;
	}
	
	public static CanadaProvince fromProvinceCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (CanadaProvince p : CanadaProvince.values()){
				if (codeUpper.equals(p.getProvinceCode())){
					return p;
				}
			}
		}
		return null;
	}
}

