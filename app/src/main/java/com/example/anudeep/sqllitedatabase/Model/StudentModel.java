package com.example.anudeep.sqllitedatabase.Model;

/**
 * Created by anudeep on 01/07/17.
 */

public class StudentModel {

    String name;
    String phnum;

    public StudentModel(String  phnum, String name) {

        this.phnum = phnum;
        this.name = name;
    }

    public StudentModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnun(String phnum) {
        this.phnum = phnum;
    }
}
