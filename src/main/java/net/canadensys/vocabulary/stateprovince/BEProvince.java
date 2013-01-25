package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
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
public enum BEProvince implements StateProvinceEnum{
	//Provinces
	ANTWERP("VAN","Antwerp"),
	EAST_FLANDERS("VOV","East Flanders"),
	FLEMISH_BRABANT("VBR","Flemish Brabant"),
	HAINAUT("WHT","Hainaut"),
	LIMBURG("VLI","Limburg"),
	LIEGE("WLG","Liège"),
	LUXEMBOURG("WLX","Luxembourg"),
	NAMUR("WNA","Namur"),
	WALLOON_BRABANT("WBR","Walloon Brabant"),
	WEST_FLANDERS("VWV","West Flanders"),
	//Regions
	BRUSSELS_CAPITAL_REGION("BRU","Brussels-Capital Region"),
	FLEMISH_REGION("VLG","Flemish Region"),
	WALLOON_REGION("WAL","Walloon Region");
		
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

