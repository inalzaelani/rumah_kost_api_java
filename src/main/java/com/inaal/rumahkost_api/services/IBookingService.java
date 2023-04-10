package com.inaal.rumahkost_api.services;


import java.util.List;

public interface IBookingService<Booking> {
    List<Booking> findAll();
    Booking findById(Long id) throws Exception;
    void save(Booking booking);
    void delete(Booking booking) throws Exception;
    void update(Booking booking) throws Exception;
    List<com.inaal.rumahkost_api.models.entity.Booking> monthReport(Integer year, Integer month) throws Exception;

}
