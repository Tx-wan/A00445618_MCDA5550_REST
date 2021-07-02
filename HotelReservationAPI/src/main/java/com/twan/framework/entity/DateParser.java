package com.twan.framework.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	public DateParser() {
		
	}
	
	public Date dateWithoutTime (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = date;
		try {
			dateWithoutTime = sdf.parse(sdf.format(date));
		}catch(ParseException e) {
			
		}
		
		return dateWithoutTime;
	}
	
}
