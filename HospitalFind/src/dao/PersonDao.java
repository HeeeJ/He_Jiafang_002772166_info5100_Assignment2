package dao;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import static dao.CommunityDao.con;
import static dao.CommunityDao.rs;
import static dao.HospitalDao.con;
import static dao.HospitalDao.rs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import model.persons.Person;
import utils.JDBCUtil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.hospitals.Hospital;
import model.hospitals.HospitalDir;
import model.persons.CommunityAdmin;
import model.persons.Doctor;
import model.persons.DoctorDir;
import model.persons.Patient;
import model.persons.PatientDir;
import model.persons.SystemAdmin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jiaf
 */
public class PersonDao {
    
    public static Connection con = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;
    
    public static Patient patientlogin(String account, String password) throws SQLException{
        Patient p = new Patient();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where acc=? and password=? and role=?");
            
            stmt.setString(1, account);
            stmt.setString(2, password);
            stmt.setString(3,"patient");
            
            rs = stmt.executeQuery();
            while(rs.next()){
                //set basic person details
                p.setAccount(account);
                p.setId(rs.getInt("id"));
                p.setRole(rs.getString("role"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getString("age"));
                p.setGender(rs.getString("gender"));
                p.setHouseId(rs.getInt("houseId"));
 
                return p;
                }
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }
    
    public static Doctor doclogin(String account, String password) throws SQLException{
        Doctor d = new Doctor();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where acc=? and password=? and role=?");

            stmt.setString(1, account);
            stmt.setString(2, password);
            stmt.setString(3, "doctor");

            rs = stmt.executeQuery();
            while(rs.next()){
                //set basic person details
                d.setAccount(account);
                d.setId(rs.getInt("id"));
                d.setRole(rs.getString("role"));
                d.setName(rs.getString("name"));
                d.setAge(rs.getString("age"));
                d.setGender(rs.getString("gender"));
                d.setMajor(rs.getString("major"));
                d.setHospitalId(rs.getInt("hospitalId"));

                return d;
                }
                    }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
}
        
    public static CommunityAdmin calogin(String account, String password) throws SQLException{
        CommunityAdmin ca = new CommunityAdmin();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where acc=? and password=? and role=?");

            stmt.setString(1, account);
            stmt.setString(2, password);
            stmt.setString(3, "comAdmin");

            rs = stmt.executeQuery();
            while(rs.next()){
                //set basic person details
                ca.setAccount(account);
                ca.setId(rs.getInt("id"));
                ca.setRole(rs.getString("role"));
                ca.setName(rs.getString("name"));
                ca.setAge(rs.getString("age"));
                ca.setGender(rs.getString("gender"));
                ca.setComId(rs.getInt("comId"));
                       
                return ca;
                }
                    }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static SystemAdmin salogin(String account, String password) throws SQLException{
        SystemAdmin sa = new SystemAdmin();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where acc=? and password=? and role=?");

            stmt.setString(1, account);
            stmt.setString(2, password);
            stmt.setString(3, "sysAdmin");

            rs = stmt.executeQuery();
            while(rs.next()){
                //set basic person details
                sa.setAccount(account);
                sa.setId(rs.getInt("id"));
                sa.setRole(rs.getString("role"));
                sa.setName(rs.getString("name"));
                sa.setAge(rs.getString("age"));
                sa.setGender(rs.getString("gender"));

 
                return sa;
                }
                    }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> paHouse(Patient p){
        
        int id = p.getId();
        String house = null;
        String community = null;
        String city = null;
        List<String> address = new ArrayList<>();
        
        int houseId = 0;
        int comId = 0;
        int cityId = 0;

        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select houseId from Persons where id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                houseId = rs.getInt("houseId");
            }
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select comId, name from houses where id=?");
            stmt1.setInt(1, houseId);
            rs = stmt1.executeQuery();
            while(rs.next()){
                comId = rs.getInt("comId");
                house = rs.getString("name");
            }
            
            PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("Select cityId, name from communities where id=?");
            stmt2.setInt(1, comId);
            rs = stmt2.executeQuery();
            while(rs.next()){
                cityId = rs.getInt("cityId");
                community = rs.getString("name");
            }
            
            PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("Select name from cities where id=?");
            stmt3.setInt(1, cityId);
            rs = stmt3.executeQuery();
            while(rs.next()){
                city = rs.getString("name");
            }
            
            address.add(0,house);
            address.add(1,community);
            address.add(2,city);
            
            return address;
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CANNOT FIND YOUR HOUSE.");
	}
        return null;
    }
    
    public static List<String> allHouse(){
        List<String> houses = new ArrayList<>();

        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select name from houses;");
            rs = stmt.executeQuery();
            
            while(rs.next()){        
                String house = null;
                house = rs.getString("name");
                houses.add(house);
            }
            
            return houses;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND All HOUSE.");
        }
        return null;
    }
    
    public static List<String> getComNCity(String house){
        List<String> comNCity = new ArrayList<>();
        String com = null;
        String city = null;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select communities.name from communities"
                    + " inner join houses where houses.name =? and communities.id = houses.comId;");
            stmt.setString(1, house);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                com = rs.getString("communities.name");
                comNCity.add(0,com);
            }
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select cities.name from cities"
                    + " inner join communities where communities.name =? and communities.cityId = cities.id;");
            stmt1.setString(1, com);
            rs = stmt1.executeQuery();
            
            while(rs.next()){
                city = rs.getString("cities.name");
                comNCity.add(1,city);
            }
            //System.out.println(comNCity);
            return comNCity;
                
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND All HOUSE.");
        }
        return null;
    }

    public static void updatePatient(Patient p){
        int id = p.getId();
        String name = p.getName();
        String age = p.getAge();
        String gender = p.getGender();
        String house = p.getHouse();
        int houseId = 0;
        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select id from houses where name=?");

            stmt.setString(1, house);
          

            rs = stmt.executeQuery();
            while(rs.next()){
                //set basic person details
                houseId = rs.getInt("id");
                }
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Update persons"
                    + " set name=?, age=?, gender=?, houseId=?"
                    + " where id=?" );
            stmt1.setString(1, name);
            stmt1.setString(2, age);
            stmt1.setString(3, gender);
            stmt1.setInt(4, houseId);
            stmt1.setInt(5, id);
            stmt1.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static DoctorDir findDocsByHos(int hosId) throws SQLException{
        DoctorDir docs = new DoctorDir();
        List<Doctor> ls = new ArrayList<>();
        
        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where hospitalId=?");
            
            stmt.setInt(1, hosId);
            rs = stmt.executeQuery();
            while(rs.next()){

                Doctor tmp = new Doctor();
                tmp.setName(rs.getString("name"));
                tmp.setAge(rs.getString("age"));
                tmp.setGender(rs.getString("gender"));
                tmp.setMajor(rs.getString("major"));
                tmp.setWorkTime(rs.getString("workTime"));
                
                ls.add(tmp);
                }
            docs.setDoctorDir(ls);

            return docs;
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }
    
    
    public static void updateDoctor(Doctor p){
        int id = p.getId();
        String name = p.getName();
        String age = p.getAge();
        String gender = p.getGender();
        String major = p.getMajor();

        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Update persons"
                    + " set name=?, age=?, gender=?, major=?"
                    + " where id=?" );
            stmt1.setString(1, name);
            stmt1.setString(2, age);
            stmt1.setString(3, gender);
            stmt1.setString(4, major);
            stmt1.setInt(5, id);
            stmt1.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Patient> allPatientName() throws SQLException{
        
        List<Patient> list = new ArrayList<>();
        
        try {
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select id, name, age, gender, acc from persons where role=?;");
            stmt.setString(1, "patient");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Patient tmp = new Patient();
                
                tmp.setId(rs.getInt("id"));
                tmp.setName(rs.getString("name"));
                tmp.setAccount(rs.getString("acc"));
                tmp.setAge(rs.getString("age"));
                tmp.setGender(rs.getString("gender"));
                
                list.add(tmp);                
            }
            
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static List<String> selectedPaDetails(String name) throws SQLException{
        
        List<String> list = new ArrayList<>();
        String gender =null;
        String age = null;
        String account = null;
        Integer id = 0;
        try {
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select id, age, gender, acc from persons where role=? and name=?;");
            stmt.setString(1, "patient");
            stmt.setString(2, name);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                gender = rs.getString("gender");
                age = rs.getString("age");
                account = rs.getString("acc");
                id = rs.getInt("id");
            }
            
            list.add(0,age);
            list.add(1,gender);
            list.add(2,account);
            list.add(3,id.toString());
            
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static void updateComAdmin(CommunityAdmin c){
        int id = c.getId();
        String name = c.getName();
        String age = c.getAge();
        String gender = c.getGender();
        int comId = c.getComId();

        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Update persons"
                    + " set name=?, age=?, gender=?, comId=?"
                    + " where id=?" );
            stmt1.setString(1, name);
            stmt1.setString(2, age);
            stmt1.setString(3, gender);
            stmt1.setInt(4, comId);
            stmt1.setInt(5, id);
            stmt1.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateSysAdmin(SystemAdmin c){
        int id = c.getId();
        String name = c.getName();
        String age = c.getAge();
        String gender = c.getGender();

        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Update persons"
                    + " set name=?, age=?, gender=?"
                    + " where id=?" );
            stmt1.setString(1, name);
            stmt1.setString(2, age);
            stmt1.setString(3, gender);
            stmt1.setInt(4, id);
            stmt1.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewDoc(Doctor d, String hospital) throws SQLException {
        Doctor doc = d;
        int hosId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select id from  hospitals"
                    + " where name = ?");
            stmt1.setString(1, hospital);
            rs = stmt1.executeQuery();
            
            if(rs.next()){
                hosId = rs.getInt("id");
            }
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into persons "
                    + "(name, acc, password, role, age, hospitalId, major, gender, workTime) "
                    + "values "
                    + "(?, ?, '123456', 'doctor', ?, ?, ?, ?, ?);");
            stmt.setString(1, doc.getName());
            stmt.setString(2, doc.getAccount());
            stmt.setString(3, doc.getAge());
            stmt.setInt(4, hosId);
            stmt.setString(5, doc.getMajor());
            stmt.setString(6, doc.getGender());
            stmt.setString(7, doc.getWorkTime());

            
            stmt.executeUpdate();
            
        }catch(SQLException e){
           throw new SQLException();
        }
    }

    public static void addNewComminityAdmin(CommunityAdmin comAdmin, String comName) throws SQLException {
        CommunityAdmin com = comAdmin;
        int comId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select id from  communities"
                    + " where name = ?");
            stmt1.setString(1, comName);
            rs = stmt1.executeQuery();
            
            if(rs.next()){
                comId = rs.getInt("id");
            }
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into persons "
                    + "(name, acc, password, role, age, comId, gender) "
                    + "values "
                    + "(?, ?, '123456', 'comAdmin', ?, ?, ?);");
            stmt.setString(1, com.getName());
            stmt.setString(2, com.getAccount());
            stmt.setString(3, com.getAge());
            stmt.setInt(4, comId);
            stmt.setString(5, com.getGender());

            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new SQLException();
        }
    }

    public static List<Person> allUsers() {
        List<Person> allPersons = new ArrayList<>();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from persons;");
            rs = stmt.executeQuery();
            
            while(rs.next()){        
                Person p = new Person();
                p.setName(rs.getString("name"));;
                p.setAccount(rs.getString("acc"));
                p.setRole(rs.getString("role"));

                allPersons.add(p);
            }
            
            return allPersons;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("CANNOT FIND All HOUSE.");
        }
        return null;
    }
}

        
        
    
