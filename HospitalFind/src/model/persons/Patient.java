package model.persons;

public class Patient extends Person {
    
    private int houseId;
    private int encounterHisId;
    private String house;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseid) {
        this.houseId = houseId;
    }

    public int getEncounterHisId() {
        return encounterHisId;
    }

    public void setEncounterHisId(int encounterHisId) {
        this.encounterHisId = encounterHisId;
    }

    @Override
    public String toString() {
        return "Patient{"+ "id=" + id + ", account=" + account +
                ", password=" + password + ", name=" + name + ", age=" + age + ", gender=" + gender + ", role=" + role  + 
                ", house=" + houseId + ", encounterHisId=" + encounterHisId + '}';
    }
    
    public void findHospital(){}
    public void viewEncounter(){};
}
