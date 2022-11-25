package com.MatrimonyApp.utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeCount {

	
	public static int count(String date)  
	{  
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

		  LocalDate localDate = LocalDate.parse(date);
		  
	LocalDate dob = localDate;  
	
	LocalDate curDate = LocalDate.now();  
	
	Period period = Period.between(dob, curDate);  
	
	System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(), period.getDays());
	//System.out.println(period.getYears());
	return period.getYears();  
	}  

}
