package com.assignment.business;
import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String contactNumber;
    private String email;
    private String squad;
    
    
    public Player(int userId, String firstName, String lastName, String dob, String contactNumber, String email) {
        setId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDOB(dob);
        setContactNumber(contactNumber);
        setEmail(email);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
    
    public String getDOB() {
        return dob;
    }
    
    public void setDOB(String dob) {
        this.dob = dob;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}