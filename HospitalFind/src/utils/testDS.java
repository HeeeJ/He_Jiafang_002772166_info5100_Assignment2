/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
/**
 *
 * @author Jiaf
 */
public class testDS {
    public static void main(String[] args) throws SQLException {
		
		testDataSource();
		System.out.println("**********");

	}

	private static void testDataSource() throws SQLException {
            DataSource ds = new JDBCUtil().getDataSource();
            Connection con = ds.getConnection();
            Statement stmt = null;
            ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, name from Persons");
			while(rs.next()){
				System.out.println("ID="+rs.getInt("id")+", Name="+rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
