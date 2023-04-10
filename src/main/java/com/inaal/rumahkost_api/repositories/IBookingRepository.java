package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Booking;

import java.util.List;

public interface IBookingRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(T t);
    void update(T t);
    T findByRoomNumber(T t) throws Exception;
    List<Booking> reportMonthly(Integer year, Integer month);
}
