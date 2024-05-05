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

    @Column(name = "doctor_username")
    private String doctorUsername;

    @Column(name = "doctor_password")
    private String doctorPassword;



    // define constructors
    public Doctors() {

    }

    public Doctors(String name, String surname, String professiont, String workingHospital, String doctorUsername, String doctorPassword) {
        this.name = name;
        this.surname = surname;
        this.professiont = professiont;
        this.workingHospital = workingHospital;
        this.doctorUsername = doctorUsername;
        this.doctorPassword = doctorPassword;
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

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    // define toString method
    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", professiont='" + professiont + '\'' +
                ", workingHospital='" + workingHospital + '\'' +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                '}';
    }
}

