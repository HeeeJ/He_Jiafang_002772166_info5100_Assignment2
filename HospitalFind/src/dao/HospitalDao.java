/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.hospitals.Hospital;
import model.hospitals.HospitalDir;
import utils.JDBCUtil;

/**
 *
 * @author Jiaf
 */
public class HospitalDao {
        
    public static Connection con = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;
    
    public static HospitalDir findHospitalDir(String account) throws SQLException{

        HospitalDir hospitals = new HospitalDir();
        int houseId = 0;
        int comId = 0;
        List<Hospital> list = new ArrayList<>();

        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt0 = (PreparedStatement) con.prepareStatement("Select houseId from persons where acc=?");
            stmt0.setString(1, account);
            rs = stmt0.executeQuery();
            if(rs.next()){
                //System.out.println("ID="+rs.getInt("id")+", Name="+rs.getString("name"));                
                houseId = rs.getInt("houseId");
            }
            
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select comId from houses where id=?");
            stmt1.setInt(1, houseId);
            rs = stmt1.executeQuery();
            while(rs.next()){
                //System.out.println("ID="+rs.getInt("id")+", Name="+rs.getString("name"));                
                comId = rs.getInt("comId");
            }
            
            PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("Select id, name, address from hospitals where comId=?");
            stmt2.setInt(1, comId);
            rs = stmt2.executeQuery();

            while(rs.next()){
                Hospital tmp = new Hospital();
                tmp.setComId(comId);
                tmp.setHosId(rs.getInt("id"));
                tmp.setAddress(rs.getString("address"));
                tmp.setName(rs.getString("name"));
                
                list.add(tmp);
            }
            hospitals.setHospitalDir(list);
            return hospitals;
        
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }  
    
    public static HospitalDir allHospital() throws SQLException{
        
        HospitalDir hospitals = new HospitalDir();
        List<Hospital> list = new ArrayList<>();
        
        try {
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from hospitals");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Hospital tmp = new Hospital();
                tmp.setComId(rs.getInt("comId"));
                tmp.setHosId(rs.getInt("id"));
                tmp.setAddress(rs.getString("address"));
                tmp.setName(rs.getString("name"));
                
                list.add(tmp);                
            }

            hospitals.setHospitalDir(list);
            return hospitals;
        } catch (SQLException e) {
        }
        return null;
    }
}
