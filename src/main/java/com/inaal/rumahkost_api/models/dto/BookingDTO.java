package com.inaal.rumahkost_api.models.dto;

import java.time.LocalDate;
import java.util.Date;

public class BookingDTO {

    private Long kostId;

    private Long userId;

    private Date startDate;

    private Date endDate;


    public Long getKostId() {
        return kostId;
    }

    public void setKostId(Long kostId) {
        this.kostId = kostId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
