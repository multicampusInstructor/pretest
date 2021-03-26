package com.basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Review r = new Review();
		//r.makeCalendar2(2020,2);
		r.connectDB();
	}
	
	public void test1() {
		String pattern = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String today = sdf.format(new Date());
		System.out.println(today);
	}
	
	public void test2() {
		String result = String.format("%d %d %d", 2,1,2);
		System.out.println(result);
	}
	
	public void makeCalendar(int l, int s) {
		int lastday = l;
		int space = s;
		
		System.out.println("\t\t\t월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i=0;i<space;i++) {
			System.out.print("\t");
		}
		for (int i=1;i<lastday+1;i++) {
			System.out.print(i+"\t");
			if ((i+space)%7==0) {
				System.out.println();
			}
		}
		
		System.out.println("1\t2\t3\t4\t5\t6\t7");
		System.out.println("8\t9\t10\t11\t12\t13\t14");
		System.out.println("15\t16\t17\t18\t19\t20\t21");
		System.out.println("22\t23\t24\t25\t26\t27\t28");
		System.out.println("29\t30\t31");
		/**/
	}
	
	public void connectDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcURL, "scott", "tiger");
			if (con!=null) {
				System.out.println("connected");
			} else {
				System.out.println("fail");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeCalendar2(int y,int m) {
		int year = y;
		int month = m-1;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);
		
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int space = cal.get(Calendar.DAY_OF_WEEK)-1;
		
		System.out.println("\t\t\t"+m+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i=0;i<space;i++) {
			System.out.print("\t");
		}
		for (int i=1;i<lastday+1;i++) {
			System.out.print(i+"\t");
			if ((i+space)%7==0) {
				System.out.println();
			}
		}
		/*
		System.out.println("1\t2\t3\t4\t5\t6\t7");
		System.out.println("8\t9\t10\t11\t12\t13\t14");
		System.out.println("15\t16\t17\t18\t19\t20\t21");
		System.out.println("22\t23\t24\t25\t26\t27\t28");
		System.out.println("29\t30\t31");
		*/
	}

}
