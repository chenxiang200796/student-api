package com.hnufe.studentapi.entity;

public class Student {
    private String id;
    private String name;
    private String sex;
    private String phone;

    public Student(String id, String name, String sex, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return id + " " + name + " " + sex + " " + phone;
    }
    public String toLine(){
        return id + "," + name + "," + sex + "," + phone;
    }

}