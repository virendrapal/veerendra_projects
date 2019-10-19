package com.test.app.test;

import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		System.out.println("today date:"+today);
		cal.add(Calendar.YEAR, 10); // to get previous year add -1
		Date nextYear = cal.getTime();
		System.out.println("next date:"+nextYear);
	}

}
