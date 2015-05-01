package net.canadensys.vocabulary.stateprovince;

import org.apache.commons.lang3.StringUtils;


/**
 * @Deprecated this should be maintained in a dictionary file.
 * https://github.com/WingLongitude/shared-dictionaries/blob/master/src/main/resources/dictionaries/geography/CO_ISO3166-2.txt
 *  
 * Enumeration representing the Colombia departments
 * TODO : override valueOf(String)
 * @author canadensys
 *
 * Sources:
 * http://en.wikipedia.org/wiki/ISO_3166-2:CO
 * 
 */
@Deprecated
public enum CODepartment implements StateProvinceEnum{
		//Capital district
		DISTRITO_CAPITAL_BOGOTA("CO-DC","Distrito Capital de Bogotá"),
		
		//Departments
		AMAZONAS("CO-AMA","Amazonas"),
		ANTIOQUIA("CO-ANT","Antioquia"),
		ARAUCA("CO-ARA","Arauca"),
		ATLANTICO("CO-ATL","Atlántico"),
		BOLIVAR("CO-BOL","Bolívar"),
		BOYACA("CO-BOY","Boyacá"),
		CALDAS("CO-CAL","Caldas"),
		CAQUETA("CO-CAQ","Caquetá"),
		CASANARE("CO-CAS","Casanare"),
		CAUCA("CO-CAU","Cauca"),
		CESAR("CO-CES","Cesar"),
		CORDOBA("CO-COR","Córdoba"),
		CUNDINAMARCA("CO-CUN","Cundinamarca"),
		CHOCO("CO-CHO","Chocó"),
		GUAINIA("CO-GUA","Guainía"),
		GUAVIARE("CO-GUV","Guaviare"),
		HUILA("CO-HUI","Huila"),
		LA_GUAJIRA("CO-LAG","La Guajira"),
		MAGDALENA("CO-MAG","Magdalena"),
		META("CO-MET","Meta"),
		NARINO("CO-NAR","Nariño"),
		NORTE_DE_SANTANDER("CO-NSA","Norte de Santander"),
		PUTUMAYO("CO-PUT","Putumayo"),
		QUINDIO("CO-QUI","Quindío"),
		RISARALDA("CO-RIS","Risaralda"),
		SAN_ANDRES_PROVIDENCIA_SANTA_CATALINA("CO-SAP","San Andrés, Providencia y Santa Catalina"),
		SANTANDER("CO-SAN","Santander"),
		SUCRE("CO-SUC","Sucre"),
		TOLIMA("CO-TOL","Tolima"),
		VALLE_DEL_CAUCA("CO-VAC","Valle del Cauca"),
		VAUPES("CO-VAU","Vaupés"),
		VICHADA("CO-VID","Vichada");
		
		private final String departmentCode;
		private final String departmentName;

		private CODepartment(String departmentCode, String departmentName) {
			this.departmentCode = departmentCode;
			this.departmentName = departmentName;
		}
		
		@Override
		public String getCode(){
			return departmentCode;
		}
		
		@Override
		public String getName(){
			return departmentName;
		}
		
		/**
		 * Get the enumeration element from the state code.
		 * @param code
		 * @return the matching enumeration element or null if the code could not be found.
		 */
		public static CODepartment fromCode(String code){
			if (!StringUtils.isBlank(code)){
				String codeUpper = code.toUpperCase().trim();
				for (CODepartment p : CODepartment.values()){
					if (codeUpper.equals(p.departmentCode)){
						return p;
					}
				}
			}
			return null;
		}
}
