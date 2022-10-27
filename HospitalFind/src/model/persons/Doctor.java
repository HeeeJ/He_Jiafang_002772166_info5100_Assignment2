package model.persons;


public class Doctor extends Person{
    
    private int hospitalId;
    private String major;

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", account=" + account + ", password=" +
                password + ", name=" + name + ", age=" + age + ", gender=" + gender+ ", role=" + role+
                "hospital=" + hospitalId + ", major=" + major + '}';
    }
    
    

    public void addEncounter(){}
    public void removeEncounter(){}
    public void viewEncounter(){}
}
