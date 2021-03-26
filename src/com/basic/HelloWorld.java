package com.basic;
import java.sql.Date;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println(Cards.diamond.toString());
		Cards cd = Cards.diamond;
		int idx = cd.ordinal();
		System.out.println(idx);
		Date date = new Date(System.currentTimeMillis());
		String format = String.format("%tY/%tm/%td",date,date,date);
		String format1 = String.format("%tF/%tT",date,date);
		System.out.println(format);
		System.out.println(format1);
	}
	
	enum Cards {
		heart,spade,clover,diamond
	}

}
