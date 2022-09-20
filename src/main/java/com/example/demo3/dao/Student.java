package com.example.demo3.dao;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;
    private String lastname;
    private String firstname;
    private Boolean isVillager;
    private Integer course;
    private Integer group;
    private Double avgMark;

    public Student() {
    }

    public Student(Long id, String lastname, String firstname, Boolean isVillager, Integer course, Integer group, Double avgMark) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.isVillager = isVillager;
        this.course = course;
        this.group = group;
        this.avgMark = avgMark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getVillager() {
        return isVillager;
    }

    public void setVillager(Boolean villager) {
        isVillager = villager;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Double avgMark) {
        this.avgMark = avgMark;
    }
}
