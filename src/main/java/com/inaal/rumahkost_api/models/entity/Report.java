package com.inaal.rumahkost_api.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "v_report")
public class Report implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kost_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonBackReference
    private Kost kost;
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


    public Kost getKost() {
        return kost;
    }

    public void setKost(Kost kost) {
        this.kost = kost;
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
