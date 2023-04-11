package com.inaal.rumahkost_api.models.dto;

public class ReportDTO {
    private Long kostId;
    private String kostName;
    private Integer month;
    private Integer year;
    private Integer jumlahBooking;
    private Double total;

    public ReportDTO(Long kostId, String kostName, Integer month, Integer year, Integer jumlahBooking, Double total) {
        this.kostId = kostId;
        this.kostName = kostName;
        this.month = month;
        this.year = year;
        this.jumlahBooking = jumlahBooking;
        this.total = total;
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
