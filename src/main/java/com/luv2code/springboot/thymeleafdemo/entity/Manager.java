package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    // Fields
    @Id
    @GeneratedValue
    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    // default constructor
    public Manager(){

    }
    // constructor
    public Manager(int managerId, String name, String surname) {
        this.managerId = managerId;
        this.name = name;
        this.surname = surname;
    }


    // Getters and Setters
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    // toString method
    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
