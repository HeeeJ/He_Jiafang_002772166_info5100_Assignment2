/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.EncounterDao.con;
import static dao.EncounterDao.rs;
import static dao.PersonDao.con;
import static dao.PersonDao.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import model.persons.Patient;
import utils.JDBCUtil;

/**
 *
 * @author Jiaf
 */
public class CommunityDao {
    
    public static Connection con = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;
    
    public static List<String> allHouseInCom(int comId){
        List<String> houses = new ArrayList<>();

        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from houses"
                    + " where comId=?;");
            stmt.setInt(1, comId);
            rs = stmt.executeQuery();
            
            while(rs.next()){        
                String house = null;
                house = rs.getString("name");
                houses.add(house);
                
                System.out.println("================"+house);
            }
            return houses;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY HOUSE.");
        }
        return null;
    }
    
    public static String comName(int comId){
        String comName = null;
        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from communities"
                    + " where id=?;");
            stmt.setInt(1, comId);
            rs = stmt.executeQuery();
            
            if(rs.next()){        
                comName = rs.getString("name");
            }
            return comName;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY HOUSE.");
        }
        return null;
    }

    public static void addNewHouse(int comId, String newHouseName) {
      try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into houses "
                    + "(name, comId) "
                    + "values "
                    + "(?, ?);");
            stmt.setString(1, newHouseName);
            stmt.setInt(2, comId);

            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addNewCity(String text) {
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into cities "
                    + "(name) "
                    + "values "
                    + "(?);");
            stmt.setString(1, text);

            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<String> allCities() {
        List<String> cities = new ArrayList<>();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from cities");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String city = rs.getString("name");
                cities.add(city);
            }
            return cities;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY HOUSE.");
        }
        return null;
        
    }

    public static void addNewCommunity(String city, String comName) {
        int cityId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select id from cities"
                    + " where name = ?");
            stmt.setString(1, city);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                cityId = rs.getInt("id");
            }
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("insert into communities "
                    + "(name, cityId) "
                    + "values "
                    + "(?, ?);");
            stmt1.setString(1, comName);
            stmt1.setInt(2, cityId);

            stmt1.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<String> allComsInCity(String cityName) {
        List<String> coms = new ArrayList<>();
        int cityId = 0;
                try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select id from cities"
                    + " where name = ?");
            stmt.setString(1, cityName);
            rs = stmt.executeQuery();
            if(rs.next()){
                cityId = rs.getInt("id");
            }
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name from communities"
                    + " where cityId=?;");
            stmt1.setInt(1, cityId);
            rs = stmt1.executeQuery();
            
            while(rs.next()){        
                String com = null;
                com = rs.getString("name");
                coms.add(com);
            }
            return coms;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY HOUSE.");
        }
        return null;
        
    }

    public static void addNewHospital(String address, String com, String hospitalName) throws Exception{
        int comId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select id from communities"
                    + " where name = ?");
            stmt1.setString(1, com);
            rs = stmt1.executeQuery();
            if(rs.next()){
                comId = rs.getInt("id");
            }    
            
            PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("insert into hospitals "
                    + "(name, comId, address) "
                    + "values "
                    + "(?, ?, ?);");
            stmt2.setString(1, hospitalName);
            stmt2.setInt(2, comId);
            stmt2.setString(3, address);

            stmt2.executeUpdate();
            
            
            }catch(SQLException e){
            e.printStackTrace();
            System.out.println("hospital already exist.");
        }
    }

    public static List<String> allHospitals() {
        List<String> cities = new ArrayList<>();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from hospitals");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String city = rs.getString("name");
                cities.add(city);
            }
            return cities;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY Hospitals.");
        }
        return null;
        
    }

    public static List<String> allComs() {
        List<String> cities = new ArrayList<>();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from communities");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String city = rs.getString("name");
                cities.add(city);
            }
            return cities;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND ANY HOUSE.");
        }
        return null;
    }
    
    
        public static void addPatient(Patient patient, String housename) throws SQLException{
        Patient p = patient;
        int houseId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select id from  houses"
                    + " where name = ?");
            stmt1.setString(1, housename);
            rs = stmt1.executeQuery();
            
            if(rs.next()){
                houseId = rs.getInt("id");
            }
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into persons "
                    + "(name, acc, password, role, age, houseId, gender) "
                    + "values "
                    + "(?, ?, ?, 'patient', ?, ?, ?);");
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getAccount());
            stmt.setString(3,p.getPassword());
            stmt.setString(4, p.getAge());
            stmt.setInt(5, houseId);
            stmt.setString(6, p.getGender());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new SQLException();
        }
        }
    
}
