package net.canadensys.lang;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * RomanNumeral representation providing methods for converting an int or a String to a RomanNumeral.
 * @author Thoralf Gutierrez
 * Source :http://www.thorgutierrez.eu/programmation-converter.html
 * Adapted by Canadensys
 * 
 * Here is an idea of the rules applied: (source : http://en.wikipedia.org/wiki/Roman_numerals)
 * Despite the lack of standardization, an additional set of rules has been frequently applied for the 
 * last few hundred years.
 * -A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1 
 * (one thousand), 9 (nine hundreds), 0 (zero tens), and 3 (three units). To write the Roman numeral, each 
 * of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III.
 * Therefore, 1903 = MCMIII.
 * -The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. 
 * (They may appear more than three times if they appear non-sequentially, such as XXXIX.) "D", "L", and "V" 
 * can never be repeated.
 * -"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted 
 * from "D" and "M" only. "V", "L", and "D" can never be subtracted.
 * -Only one small-value symbol may be subtracted from any large-value symbol.
 */
public class RomanNumeral implements Comparable<RomanNumeral>{

	public static final int MAX_VALUE = 3999;
	public static final int MIN_VALUE = 1;
	
	private final static String[] BASIC_ROMAN_NUMERALS = { "M", "CM", "D", "CD",
			"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private final static int[] BASIC_VALUES = { 1000, 900, 500, 400, 100, 90,
			50, 40, 10, 9, 5, 4, 1 };
	
	private int value;
	private String romanString;
	
	/**
	 * Constructs a newly allocated RomanNumeral object indicated by the int parameter.
	 * @param value
	 * @throws IllegalArgumentException if the int does not contain a parsable RomanNumeral.
	 */
	public RomanNumeral(int value) throws NumberFormatException  {
	     if (MIN_VALUE <= value && value <= MAX_VALUE) {
	        this.value = value;
	     } else {
	        throw new NumberFormatException ("" + value);
	     }
	 }
	
	/**
	 * Constructs a newly allocated RomanNumeral object indicated by the String parameter.
	 * @param s
	 * @throws IllegalArgumentException if the String does not contain a parsable RomanNumeral.
	 */
	public RomanNumeral(String s) throws NumberFormatException  {
		String r = s.toUpperCase();
		int index = 0;
		for (int i = 0; i < BASIC_ROMAN_NUMERALS.length; i++) {
			while (r.startsWith(BASIC_ROMAN_NUMERALS[i], index)) {
				this.value += BASIC_VALUES[i];
				index += BASIC_ROMAN_NUMERALS[i].length();
			}
		}
		// Verifies whether the input string is a valid roman number or not.
		RomanNumeral tempVerify;
		String verifyString;
		tempVerify = new RomanNumeral(this.value);

		if ((verifyString = tempVerify.toRomanNumeral()).equals(r)) {
			this.romanString = r;
		} else {
			throw new NumberFormatException(s + ":" + verifyString);
		}
	}

	/**
	 * Get the Roman Numeral of the current value
	 * @return
	 */
	public String toRomanNumeral() {
		if (this.romanString == null) {
			this.romanString = "";
			int remainder = this.value;
			for (int i = 0; i < BASIC_VALUES.length; i++) {
				while (remainder >= BASIC_VALUES[i]) {
					this.romanString += BASIC_ROMAN_NUMERALS[i];
					remainder -= BASIC_VALUES[i];
				}
			}
		}
		return this.romanString;
	}

	/**
	 * Get the int value of this Roman Numeral
	 * @return
	 */
	public int toInt() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object o){
		if (o == null) { return false; }
		if (o == this) { return true; }
		if (o.getClass() != getClass()) {
			return false;
		}
		
		RomanNumeral rn = (RomanNumeral) o;
		return new EqualsBuilder()
		 .append(this.value, rn.value)
		 .isEquals();
	}

	@Override
	public int compareTo(RomanNumeral o) {
		return new CompareToBuilder()
			.append(this.value, o.value)
			.toComparison();
	}
}
