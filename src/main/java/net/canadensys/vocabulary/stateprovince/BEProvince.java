package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
 * Enumeration representing the Belgian provinces
 * TODO : override valueOf(String)
 * @author peterdesmet
 * Based on: http://en.wikipedia.org/wiki/Provinces_of_Belgium
 */
public enum BelgiumProvince implements StateProvinceEnum{
	//Provinces
	ANTWERP("AN","Antwerp"),
	EAST_FLANDERS("OV","East Flanders"),
	FLEMISH_BRABANT("VB","Flemish Brabant"),
	HAINAUT("HT","Hainaut"),
	LIMBURG("LI","Limburg"),
	LIEGE("LG","Liège"),
	LUXEMBOURG("LX","Luxembourg"),
	NAMUR("NA","Namur"),
	WALLOON_BRABANT("BW","Walloon Brabant"),
	WEST_FLANDERS("WV","West Flanders");
	// This does not include the Brussels-Capital Region, as it is not a province.
	
	private final String provinceCode;
	private final String provinceName;

	private BelgiumProvince(String provinceCode, String provinceName) {
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
	public static BelgiumProvince fromCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (BelgiumProvince p : BelgiumProvince.values()){
				if (codeUpper.equals(p.provinceCode)){
					return p;
				}
			}
		}
		return null;
	}
}

