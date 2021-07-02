package com.twan.framework.entity;


public class GenderConvertor {
	public static Gender Convertor(String str_gender) {
		Gender g = null;
		
		if (str_gender.toLowerCase().equals("male")) {
			g = Gender.MALE;
		} else if (str_gender.toLowerCase().equals("female")) {
			g = Gender.FEMALE;
		} else {
			g = Gender.NONIDENTIFIED;
		}
		
		return g;
	}

}
