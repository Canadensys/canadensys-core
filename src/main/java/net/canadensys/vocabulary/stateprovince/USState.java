package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;

/**
 * Enumeration representing the United States of America states.
 * TODO : override valueOf(String)
 * @author canadensys
 *
 */
public enum USState implements StateProvinceEnum {

	ALABAMA("AL", "Alabama"),
	ALASKA("AK", "Alaska"),
	ARIZONA("AZ", "Arizona"),
	ARKANSAS("AR", "Arkansas"),
	CALIFORNIA("CA", "California"),
	COLORADO("CO", "Colorado"),
	CONNECTICUT("CT", "Connecticut"),
	DELAWARE("DE", "Delaware"),
	FLORIDA("FL", "Florida"),
	GEORGIA("GA", "Georgia"),
	HAWAII("HI", "Hawaii"),
	IDAHO("ID", "Idaho"),
	ILLINOIS("IL", "Illinois"),
	INDIANA("IN", "Indiana"),
	IOWA("IA", "Iowa"),
	KANSAS("KS", "Kansas"),
	KENTUCKY("KY", "Kentucky"),
	LOUISIANA("LA", "Louisiana"),
	MAINE("ME", "Maine"),
	MARYLAND("MD", "Maryland"),
	MASSACHUSETTS("MA", "Massachusetts"),
	MICHIGAN("MI", "Michigan"),
	MINNESOTA("MN", "Minnesota"),
	MISSISSIPPI("MS", "Mississippi"),
	MISSOURI("MO", "Missouri"),
	MONTANA("MT", "Montana"),
	NEBRASKA("NE", "Nebraska"),
	NEVADA("NV", "Nevada"),
	NEW_HAMPSHIRE("NH", "New Hampshire"),
	NEW_MEXICO("NM", "New Mexico"),
	NEW_YORK("NY", "New York"),
	NEW_JERSEY("NJ", "New Jersey"),
	NORTH_CAROLINA("NC", "North Carolina"),
	NORTH_DAKOTA("ND", "North Dakota"),
	OHIO("OH", "Ohio"),
	OKLAHOMA("OK", "Oklahoma"),
	OREGON("OR", "Oregon"),
	PENNSYLVANIA("PA", "Pennsylvania"),
	RHODE_ISLAND("RI", "Rhode Island"),
	SOUTH_CAROLINA("SC", "South Carolina"),
	SOUTH_DAKOTA("SD", "South Dakota"),
	TENNESSEE("TN", "Tennessee"),
	TEXAS("TX", "Texas"),
	UTAH("UT", "Utah"),
	VERMONT("VT", "Vermont"),
	VIRGINIA("VA", "Virginia"),
	WASHINGTON("WA", "Washington"),
	WEST_VIRGINIA("WV", "West Virginia"),
	WISCONSIN("WI", "Wisconsin"),
	WYOMING("WY", "Wyoming");
	
	//WASHINGTON_DC("DC", "Washington D.C."),
	//PR("PR", "Puerto Rico"),
	
	private final String stateCode;
	private final String stateName;
	
	private USState(String stateCode, String stateName) {
		this.stateCode = stateCode;
		this.stateName = stateName;
	}
	
	@Override
	public String getCode(){
		return stateCode;
	}
	
	@Override
	public String getName(){
		return stateName;
	}
	
	/**
	 * Get the enumeration element from the state code.
	 * @param code
	 * @return the matching enumeration element or null if the code could not be found.
	 */
	public static USState fromCode(String code){
		if (!StringUtils.isBlank(code)){
			String codeUpper = code.toUpperCase().trim();
			for (USState s : USState.values()){
				if (codeUpper.equals(s.stateCode)){
					return s;
				}
			}
		}
		return null;
	}
}
