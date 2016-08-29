package com.tripoin.util.ui.geo;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EGeoTypes {
	
	STREET_NUMBER("street_number"),
	ROUTE("route"),
	ADMIN_AREA_LVL1("administrative_area_level_1"),
	ADMIN_AREA_LVL2("administrative_area_level_2"),
	ADMIN_AREA_LVL3("administrative_area_level_3"),
	ADMIN_AREA_LVL4("administrative_area_level_4"),
	POLITICAL("political"),
	COUNTRY("country"),
	POSTAL_CODE("postal_code"),
	LOCALITY("locality");
	
	private String operator;	
	
	private EGeoTypes(String operator){
		this.operator = operator ;
	}
	
	@Override
	public String toString() {
		return operator;
	}
	
}
