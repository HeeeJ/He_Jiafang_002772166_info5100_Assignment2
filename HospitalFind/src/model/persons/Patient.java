package model.persons;

public class Patient extends Person {
    
    private int houseId;
    private int encounterHisId;    

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
                "house=" + houseId + ", encounterHisId=" + encounterHisId + '}';
    }
    
    public void findHospital(){}
    public void viewEncounter(){};
}
