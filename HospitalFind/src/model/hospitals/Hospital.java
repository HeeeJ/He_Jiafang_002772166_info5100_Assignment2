package model.hospitals;
import java.util.List;

import model.community.Community;
import model.persons.Doctor;

public class Hospital {

    private int hosId;
    private String name;
    private String community;
    private List<Doctor> doctorInHos;
    private List<Community> accessableCommunities;

    public void addDoc(){}
    public void deleteDoc(){}
    public void viewDoc(){}
}
