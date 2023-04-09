package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Kost;

import java.util.List;

public interface IRepositories<T>{
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(T t);
    void update(T t);
}
