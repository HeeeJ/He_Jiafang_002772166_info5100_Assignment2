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
import java.time.ZoneId;
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
                tmp.setDate(rs.getDate("date").toLocalDate());
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
                
                PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("Select name "
                    + "from persons  "
                    + "where id=? ");
            
                stmt3.setInt(1, patientId);

                rs = stmt3.executeQuery();
                if(rs.next())
                    tmp.setPatient(rs.getString("name"));
                
                ls.add(tmp);
                
                ens.setEncounterHis(ls);
                return ens;
                
            }
        }catch (SQLException e) {
            e.printStackTrace();
	}
        return null;
    }
    
    public static VitalSign getSign(int vsId){
        VitalSign vs = new VitalSign();
        
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * "
                    + "from vs "
                    + "where id=? ");
            stmt.setInt(1, vsId);
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
    
    public static EncountersHistory docEncountersHistory(int docId) throws SQLException{

    EncountersHistory ens = new EncountersHistory();
    List<Encounter> ls = new ArrayList<>();


    try{
        DataSource ds = JDBCUtil.getDataSource();
        con = ds.getConnection();
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * "
                + "from encounters "
                + "where docId=? ");

        stmt.setInt(1, docId);

        rs = stmt.executeQuery();
        while(rs.next()){
            Encounter tmp = new Encounter();
            //set basic person details
            tmp.setId(rs.getInt("id"));
            tmp.setPatientId(rs.getInt("patientId"));
            tmp.setDocId(docId);
            tmp.setHosId(rs.getInt("hosId"));
            tmp.setDate((rs.getDate("date")).toLocalDate());
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
            
            PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("Select name "
                + "from persons  "
                + "where id=? ");

            stmt3.setInt(1, tmp.getPatientId());

            rs = stmt3.executeQuery();
            if(rs.next())
                tmp.setPatient(rs.getString("name"));            
            
            ls.add(tmp);

            ens.setEncounterHis(ls);
            return ens;

        }
    }catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    public static void createNewEcounter(Encounter newEncounter, VitalSign newVitalSign) {
        int vsId = 0;
        try{
            DataSource ds = JDBCUtil.getDataSource();
            con = ds.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into vs "
                    + "(Temperature, pulseRate, respirationRate, bloodPressure) "
                    + "values "
                    + "(?, ?, ?, ?);");
            stmt.setString(1, newVitalSign.getTemperature());
            stmt.setString(2, newVitalSign.getPulseRate());
            stmt.setString(3, newVitalSign.getRespirationRate());
            stmt.setString(4, newVitalSign.getBloodPressure());
            stmt.executeUpdate();
            
            PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("SELECT id FROM vs WHERE id = (SELECT MAX(id) "
                    + "FROM vs)");
            rs = stmt2.executeQuery();
            if(rs.next()){
                //set basic person details
                vsId=rs.getInt("id");
            }
            PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("insert into encounters "
                    + "(patientId, docId, date, docAdvice, hosId, vsId) "
                    + "values "
                    + "(?, ?, ?, ?, ?, ?);");
            stmt1.setInt(1, newEncounter.getPatientId());
            stmt1.setInt(2, newEncounter.getDocId());
            stmt1.setDate(3, java.sql.Date.valueOf(newEncounter.getDate()));
            stmt1.setString(4, newEncounter.getDocAdvice());
            stmt1.setInt(5, newEncounter.getHosId());
            stmt1.setInt(6, vsId);
            stmt1.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
