package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.models.entity.Booking;

import java.util.List;

public interface IBookingService<Booking> {
    List<Booking> findAll();
    Booking findById(Long id) throws Exception;
    void save(Booking booking);
    void delete(Booking booking) throws Exception;
    void update(Booking booking) throws Exception;

}
