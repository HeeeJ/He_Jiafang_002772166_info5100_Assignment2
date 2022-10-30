/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.PersonDao.con;
import static dao.PersonDao.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.persons.encounters.Encounter;
import model.persons.encounters.EncountersHistory;
import model.persons.encounters.VitalSign;
import utils.JDBCUtil;

/**
 *
 * @author Jiaf
 */
public class EncounterDao {
    public static Connection con = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;
    
    public static EncountersHistory patientEncountersHistory(int patientId) throws SQLException{
        
        EncountersHistory ens = new EncountersHistory();
        List<Encounter> ls = new ArrayList<>();

        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * "
                    + "from encounters "
                    + "where patientId=? ");
            
            stmt.setInt(1, patientId);

            rs = stmt.executeQuery();
            while(rs.next()){
                Encounter tmp = new Encounter();
                //set basic person details
                tmp.setId(rs.getInt("id"));
                tmp.setPatientId(patientId);
                tmp.setDocId(rs.getInt("docId"));
                tmp.setHosId(rs.getInt("hosId"));
                tmp.setDate(rs.getDate("date"));
                tmp.setVsId(rs.getInt("vsId"));
                tmp.setDocAdvice(rs.getString("docAdvice"));
                
                PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("Select name "
                    + "from info.hospitals  "
                    + "where hospitals.id=? ");
            
                stmt1.setInt(1, tmp.getHosId());

                rs = stmt1.executeQuery();
                if(rs.next())
                    tmp.setHospital(rs.getString("hospitals.name"));
                
                PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("Select name "
                    + "from persons  "
                    + "where id=? ");
            
                stmt2.setInt(1, tmp.getDocId());

                rs = stmt2.executeQuery();
                if(rs.next())
                    tmp.setDoctor(rs.getString("name"));
                ls.add(tmp);
                
                ens.setEncounterHis(ls);
                return ens;
                
            }
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }
    
    public static VitalSign getSign(int encounterId){
        VitalSign vs = new VitalSign();
        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * "
                    + "from vs "
                    + "where id=? ");
            stmt.setInt(1, encounterId);
            rs = stmt.executeQuery();
            while(rs.next()){
                vs.setTemperature(rs.getString("Temperature"));
                vs.setPulseRate(rs.getString("pulseRate"));
                vs.setRespirationRate(rs.getString("respirationRate"));
                vs.setBloodPressure(rs.getString("bloodPressure"));
            }
            
            return vs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }  
}
