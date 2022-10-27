package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import model.persons.Person;
import utils.JDBCUtil;
import java.sql.PreparedStatement;
import model.persons.CommunityAdmin;
import model.persons.Doctor;
import model.persons.Patient;
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
    
    public static Person login(String account, String password) throws SQLException{
        Person p = new Person();
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from Persons where account=? and password=?");
            
            
            stmt.setString(1, account);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                //System.out.println("ID="+rs.getInt("id")+", Name="+rs.getString("name"));
                
                //set basic person details
                p.setAccount(account);
                p.setId(rs.getInt("id"));
                p.setRole(rs.getString("role"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getString("age"));
                p.setGender(rs.getString("gender"));
                
                //set Patient details
                if(p.getRole() == "patient"){
                    Patient pa = (Patient)p;
                    pa.setHouseId(rs.getInt("houseId"));
                    pa.setEncounterHisId(rs.getInt("encounterHisId"));
                    System.out.println(pa.toString());
                    return pa;
                }
                //set doctor details
                else if(p.getRole() == "doctor"){
                    Doctor doc = (Doctor)p;
                    doc.setMajor(rs.getString("major"));
                    doc.setHospitalId(rs.getInt("hospitalId"));
                    System.out.println(doc.toString());
                    return doc;
                }
                //set community admin detail
                else if(p.getRole() == "comAdmin"){
                    CommunityAdmin comAd = (CommunityAdmin) p;
                    comAd.setComId(rs.getInt("comId"));
                    System.out.println(comAd.toString());
                    return comAd;
                }
                else if(p.getRole() =="sysAdmin"){
                    SystemAdmin sysAd = (SystemAdmin) p;
                    System.out.println(sysAd.toString());
                    return sysAd;
                }
                else {

                    return p;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }     
            
}
