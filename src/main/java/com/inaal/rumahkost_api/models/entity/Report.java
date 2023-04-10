package com.inaal.rumahkost_api.models.entity;

import jakarta.persistence.*;

@Entity
public class Report {
    @Id
    @Column(name = "kost_id")
    private Long kostId;
    @Column(name = "kost_name")
    private String kostName;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "jumlah_booking")
    private Integer jumlahBooking;
    @Column(name = "total")
    private Double total;



    public Report(Long kostId, String kostName, Integer month, Integer jumlahBooking, Double total) {
        this.kostId = kostId;
        this.kostName = kostName;
        this.month = month;
        this.jumlahBooking = jumlahBooking;
        this.total = total;
    }

    public Report() {

    }

    public Long getKostId() {
        return kostId;
    }

    public void setKostId(Long kostId) {
        this.kostId = kostId;
    }

    public String getKostName() {
        return kostName;
    }

    public void setKostName(String kostName) {
        this.kostName = kostName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getJumlahBooking() {
        return jumlahBooking;
    }

    public void setJumlahBooking(Integer jumlahBooking) {
        this.jumlahBooking = jumlahBooking;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
