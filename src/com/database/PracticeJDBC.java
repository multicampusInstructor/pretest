package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PracticeJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeJDBC p = new PracticeJDBC();
		try {
			p.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readAll() throws SQLException {
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from t_member");
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		while(rs.next()) {
			for(int i=0;i<count;i++) {
				System.out.print(rs.getString(i+1)+"\t");
			}
			System.out.println();
		}
		String c = con.getCatalog();
		//String d = con.getSchema();
		System.out.println(c);
		rs.close();
		pstmt.close();
		con.close();
	}
	public Connection getConnection() {
		Connection con = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL, "scott", "tiger");
			if (con!=null) {
				System.out.println("connected");
			} else {
				System.out.println("fail");
			}
			//con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
