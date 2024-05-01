package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class  Doctors{
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;

    @Column(name="professiont")
    private String professiont;

    @Column(name = "working_hospital")
    private String workingHospital;


    // define constructors
    public Doctors() {

    }

    public Doctors(String name, String surname, String professiont, String workingHospital) {
        this.name = name;
        this.surname = surname;
        this.professiont = professiont;
        this.workingHospital = workingHospital;
    }

    // define getter/setter

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfessiont() {
        return professiont;
    }

    public void setProfessiont(String professiont) {
        this.professiont = professiont;
    }

    public String getWorkingHospital() {
        return workingHospital;
    }

    public void setWorkingHospital(String workingHospital) {
        this.workingHospital = workingHospital;
    }


    // define toString
    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", professiont='" + professiont + '\'' +
                ", workingHospital='" + workingHospital + '\'' +
                '}';
    }
}








