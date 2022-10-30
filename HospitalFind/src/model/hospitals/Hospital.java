package model.hospitals;

public class Hospital {

    private int hosId;
    private String name;
    private String address;
    private int comId;

    public int getHosId() {
        return hosId;
    }

    public void setHosId(int hosId) {
        this.hosId = hosId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    
    
    public void addDoc(){}
    public void deleteDoc(){}
    public void viewDoc(){}
}
