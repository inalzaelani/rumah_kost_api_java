package com.inaal.rumahkost_api.models.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class BookingDTO {

    @NotBlank(message = "{invalid.kost.id}")
    private Long kostId;

    @NotBlank(message = "{invalid.user.id}")
    private Long userId;
    @NotBlank(message = "{invalid.room.number}")
    @Pattern(regexp="(^$|[0-9]{10})", message = "{invalid.format.room.number}")
    private String roomNumber;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{invalid.start.date}")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{invalid.end.date}")
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
