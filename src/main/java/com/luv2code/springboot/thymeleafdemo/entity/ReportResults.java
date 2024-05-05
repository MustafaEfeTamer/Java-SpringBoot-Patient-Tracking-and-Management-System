package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "report_results")
public class ReportResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_result_id")
    private int reportResultId;

    @Column(name = "report_id")
    private int reportId;

    @Column(name = "url")
    private String url;

    public ReportResults(){

    }

    public ReportResults(int reportResultId, int reportId, String url) {
        this.reportResultId = reportResultId;
        this.reportId = reportId;
        this.url = url;
    }

    public int getReportResultId() {
        return reportResultId;
    }

    public void setReportResultId(int reportResultId) {
        this.reportResultId = reportResultId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ReportResults{" +
                "reportResultId=" + reportResultId +
                ", reportId=" + reportId +
                ", url='" + url + '\'' +
                '}';
    }
}
