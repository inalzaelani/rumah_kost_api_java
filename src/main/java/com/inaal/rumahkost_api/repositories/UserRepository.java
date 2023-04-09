package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Kost;
import com.inaal.rumahkost_api.models.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository implements IRepositories<User>{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM m_user", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return (User) entityManager.createNativeQuery("SELECT * FROM m_user WHERE id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.createNativeQuery("INSERT INTO m_user (name, email, phone) VALUES (:name, :email, :phone)")
                .setParameter("name", user.getName())
                .setParameter("email", user.getEmail())
                .setParameter("phone", user.getPhone())
                .executeUpdate();
    }

    @Override
    public void delete(User user) {
        entityManager.createNativeQuery("DELETE FROM m_user WHERE id = :id")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.createNativeQuery("UPDATE m_user SET name = :name, email = :email, phone = :phone WHERE id = :id")
                .setParameter("name", user.getName())
                .setParameter("email", user.getEmail())
                .setParameter("phone", user.getPhone())
                .setParameter("id", user.getId())
                .executeUpdate();
    }
}
