package com.simple.registration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String gender;
    private String course;
    private float tenthMarks;
    private float interMarks;
    private float bachelorMarks;
    private float masterMarks;
    private String photo; 
    private String sig;  

    // Getters, setters, and constructors
    public Registration() {}

    public Registration(String name, int age, String gender, String course, float tenthMarks, float interMarks,
                        float bachelorMarks, float masterMarks, String photo, String sig) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.tenthMarks = tenthMarks;
        this.interMarks = interMarks;
        this.bachelorMarks = bachelorMarks;
        this.masterMarks = masterMarks;
        this.photo = photo;
        this.sig = sig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getTenthMarks() {
        return tenthMarks;
    }

    public void setTenthMarks(float tenthMarks) {
        this.tenthMarks = tenthMarks;
    }

    public float getInterMarks() {
        return interMarks;
    }

    public void setInterMarks(float interMarks) {
        this.interMarks = interMarks;
    }

    public float getBachelorMarks() {
        return bachelorMarks;
    }

    public void setBachelorMarks(float bachelorMarks) {
        this.bachelorMarks = bachelorMarks;
    }

    public float getMasterMarks() {
        return masterMarks;
    }

    public void setMasterMarks(float masterMarks) {
        this.masterMarks = masterMarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}
