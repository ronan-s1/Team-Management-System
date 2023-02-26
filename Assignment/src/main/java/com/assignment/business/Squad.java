package com.assignment.business;

import java.io.Serializable;

public class Squad implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    
    public Squad(int id, String squadname) {
        super();
        this.id = id;
        this.name = squadname;
    }
    
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
