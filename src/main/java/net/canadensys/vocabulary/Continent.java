package net.canadensys.vocabulary;

import org.apache.commons.lang3.StringUtils;

/**
 * Controlled vocabulary for continents (seven-continent model)
 * @author canadensys
 *
 */
public enum Continent {

	AFRICA("AF", "Africa"),
	ASIA("AS", "Asia"),
	EUROPE("EU", "Europe"),
	NORTH_AMERICA("NA", "North America"),
	SOUTH_AMERICA("SA", "South America"),
	OCEANIA("OC", "Oceania"),
	ANTARCTICA("AN", "Antarctica");

	private final String code;
	private final String title;

	private Continent(String code, String title) {
		this.code = code;
		this.title = title;
	}

	/**
	 * @return the country name in the English language.
	 */
	public String getTitle() {
		return title;
	}
	
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *            the case insensitive continent code
	 * 
	 * @return the matching continent or null
	 */
	public static Continent fromCode(String code) {
		if (!StringUtils.isBlank(code)) {
			for (Continent c : Continent.values()) {
				if (code.equalsIgnoreCase(c.code)) {
					return c;
				}
			}
		}
		return null;
	}
}
