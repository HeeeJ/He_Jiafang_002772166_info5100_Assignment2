package model.persons.encounters;

import java.util.Date;

public class Encounter{

    private int id;
    private int patientId;
    private int hosId;
    private int docId;
    private Date date;

    private int vsId;
    private String docAdvice;
    private String hospital;
    private String doctor;
    private String patient;

    public int getVsId() {
        return vsId;
    }

    public void setVsId(int vsId) {
        this.vsId = vsId;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getHosId() {
        return hosId;
    }

    public void setHosId(int hosId) {
        this.hosId = hosId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDocAdvice() {
        return docAdvice;
    }

    public void setDocAdvice(String docAdvice) {
        this.docAdvice = docAdvice;
    }

    @Override
    public String toString() {
        return hospital;
    }
    
    
}