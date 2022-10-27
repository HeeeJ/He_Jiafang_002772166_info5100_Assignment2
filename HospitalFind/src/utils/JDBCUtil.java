/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLDataException;
import java.util.Properties;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.FileInputStream;
import java.io.IOException;
/**
 *
 * @author Jiaf
 */
public class JDBCUtil {
    
    private static DataSource ds;
    static{
        
        Properties properties = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        
        try {
            fis = new FileInputStream("D:\\Jiaf\\Documents\\GitHub\\He_Jiafang_002772166_info5100_Assignment2\\HospitalFind\\src\\utils\\db.properties");
            properties.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(properties.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
            ds = mysqlDS;
	} catch (IOException e) {
            e.printStackTrace();
	}
        
    }
    
    public static DataSource getDataSource() {
        return ds;
    }
    /**
     * Generate database connection.
     * @return Connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
