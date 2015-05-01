package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
 * @Deprecated
 * https://github.com/WingLongitude/shared-dictionaries/blob/master/src/main/resources/dictionaries/geography/BE_ISO3166-2.txt
 * 
 * Enumeration representing the Belgian provinces
 * TODO : override valueOf(String)
 * @author peterdesmet
 *
 * Sources:
 * http://en.wikipedia.org/wiki/Provinces_of_Belgium
 * http://en.wikipedia.org/wiki/ISO_3166-2:BE
 * 
 * Note:
 * The regions VLG and WAL are both a set of 5 provinces.
 * The first letter of the province (V, W) indicates to what region these belong.
 * The region BRU is not a province, nor does it contain any provinces.
 */
@Deprecated
public enum BEProvince implements StateProvinceEnum{
	//Provinces
	ANTWERP("BE-VAN","Antwerp"),
	EAST_FLANDERS("BE-VOV","East Flanders"),
	FLEMISH_BRABANT("BE-VBR","Flemish Brabant"),
	HAINAUT("BE-WHT","Hainaut"),
	LIMBURG("BE-VLI","Limburg"),
	LIEGE("BE-WLG","Liège"),
	LUXEMBOURG("BE-WLX","Luxembourg"),
	NAMUR("BE-WNA","Namur"),
	WALLOON_BRABANT("BE-WBR","Walloon Brabant"),
	WEST_FLANDERS("BE-VWV","West Flanders"),
	//Regions
	BRUSSELS_CAPITAL_REGION("BE-BRU","Brussels-Capital Region"),
	FLEMISH_REGION("BE-VLG","Flemish Region"),
	WALLOON_REGION("BE-WAL","Walloon Region");
		
	private final String provinceCode;
	private final String provinceName;

	private BEProvince(String provinceCode, String provinceName) {
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
	public static BEProvince fromCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (BEProvince p : BEProvince.values()){
				if (codeUpper.equals(p.provinceCode)){
					return p;
				}
			}
		}
		return null;
	}
}

