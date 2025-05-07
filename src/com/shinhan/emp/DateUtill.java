package com.shinhan.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// db 연결이다!!
public class DateUtill {
	
	public static String convertToString(Date d1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(d1); // 날짜 -> 문자
		return str;
	}
	
	public static Date convertToDate(String str2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = null;
		
		try {
			d2 = sdf.parse(str2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d2; 
	}
	
	public static java.sql.Date convertTOSQLDate(Date d){
		return new java.sql.Date(d.getTime());
	}
}
