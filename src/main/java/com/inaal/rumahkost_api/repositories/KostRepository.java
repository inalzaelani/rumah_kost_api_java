package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Kost;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KostRepository implements IRepositories<Kost> {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Kost> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM m_kost", Kost.class).getResultList();
    }

    @Override
    public Kost findById(Long id) {
        return  (Kost) entityManager.createNativeQuery("SELECT * FROM m_kost WHERE id = :id", Kost.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public void save(Kost kost) {
         entityManager.createNativeQuery("INSERT INTO m_kost  (name, address, price, capacity) VALUES (:name, :address, :price, :capacity)")
                .setParameter("name", kost.getName())
                .setParameter("address", kost.getAddress())
                .setParameter("price", kost.getPrice())
                .setParameter("capacity", kost.getCapacity())
                .executeUpdate();
    }

    @Override
    public void delete(Kost kost) {
        entityManager.createNativeQuery("DELETE FROM m_kost  WHERE id = :id")
                .setParameter("id", kost.getId())
                .executeUpdate();
    }

    @Override
    public void update(Kost kost) {
        entityManager.createNativeQuery("UPDATE m_kost SET name = :name, address = :address, price = :price, capacity = :capacity WHERE id = :id")
                .setParameter("name", kost.getName())
                .setParameter("address", kost.getAddress())
                .setParameter("price", kost.getPrice())
                .setParameter("available", kost.getCapacity())
                .setParameter("id", kost.getId())
                .executeUpdate();
    }
}
