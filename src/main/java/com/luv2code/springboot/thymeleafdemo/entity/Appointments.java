package com.luv2code.springboot.thymeleafdemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="appointments")
public class Appointments {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointment_id")
    private int id;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="doctor_id")
    private int doctorId;

    @Column(name="appointment_date")
    private String appointmentDate;

    @Column(name="appointment_time")
    private String appointmentTime;

    @Column(name="doctor_name")
    private String doctorName;

    @Column(name="patient_name")
    private String patientName;

    public Appointments(){

    }


    public Appointments(int patientId, int doctorId, String appointmentDate, String appointmentTime, String doctorName, String patientName) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.doctorName = doctorName;
        this.patientName = patientName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
