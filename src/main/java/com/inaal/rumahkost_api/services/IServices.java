package com.inaal.rumahkost_api.services;

import java.util.List;

public interface IServices<T> {
    List<T> getAllService();
    T getByIdService(Long id) throws Exception;
    void saveService(T t);
    void deleteService(T t) throws Exception;
    void updateService(T t) throws Exception;
}
