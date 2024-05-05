package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="reports")
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int id;
    @Column(name = "report_time")
    private String reportTime;
    @Column(name = "report_content")
    private String reportContent;
    @Column(name = "patient_id")
    private int patientId;


    public Reports(){

    }

    public Reports(int id, String reportTime, String reportContent, int patientId) {
        this.id = id;
        this.reportTime = reportTime;
        this.reportContent = reportContent;
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id=" + id +
                ", reportTime='" + reportTime + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}
