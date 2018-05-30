package com.wpalermo.socioTorcedor.utils;

public enum HystrixKeyEnum {
	
	CAMPANHA(new String("CAMPANHA_SERVICE"));
	
	
	public String key;
	
	private HystrixKeyEnum(String key) {
		this.key = key;
	}

}
