package com.inaal.rumahkost_api.repositories;

import java.util.List;

public interface IBookingRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(T t);
    void update(T t);
    T findByRoomNumber(T t) throws Exception;
}
