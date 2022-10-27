package model.persons;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jiaf
 */
public class Person {
    
    //account info
    protected int id;
    protected String account;
    protected String password;
    protected String role;
    
    //personal details
    protected String name;
    protected String age;
    protected String gender;
  

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", account=" + account + ", password=" + password +
                ", name=" + name + ", age=" + age + ", gender=" + gender + ", role=" + role + '}';
    }
    
    
    
    

}
