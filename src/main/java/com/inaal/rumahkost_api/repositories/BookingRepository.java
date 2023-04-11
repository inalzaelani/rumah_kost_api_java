package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.models.entity.Report;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookingRepository implements IBookingRepository<Booking>{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Booking> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM t_booking", Booking.class).getResultList();
    }

    @Override
    public Booking findById(Long id) {
        return (Booking) entityManager.createNativeQuery("SELECT * FROM t_booking WHERE id = :id", Booking.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Booking booking) {
        entityManager.createNativeQuery("INSERT INTO t_booking (user_id, kost_id, room_number,start_date, end_date) VALUES (:user_id, :kost_id, :room_number ,:start_date, :end_date)")
                .setParameter("user_id", booking.getUser().getId())
                .setParameter("kost_id", booking.getKost().getId())
                .setParameter("room_number", booking.getRoomNumber())
                .setParameter("start_date", booking.getStartDate())
                .setParameter("end_date", booking.getEndDate())
                .executeUpdate();

    }

    @Override
    public void delete(Booking booking) {
        entityManager.createNativeQuery("DELETE FROM t_booking WHERE id = :id")
                .setParameter("id", booking.getId())
                .executeUpdate();
    }

    @Override
    public void update(Booking booking) {
        entityManager.createNativeQuery("UPDATE t_booking SET user_id = :user_id, kost_id = :kost_id, room_number = :room_number, start_date = :start_date, end_date = :end_date")
         .setParameter("user_id", booking.getUser().getId())
                .setParameter("kost_id", booking.getKost().getId())
                .setParameter("room_number", booking.getRoomNumber())
                .setParameter("start_date", booking.getStartDate())
                .setParameter("end_date", booking.getEndDate())
                .executeUpdate();
    }

    @Override
    public Booking findByRoomNumber(Booking booking) throws Exception {
        return (Booking)entityManager.createNativeQuery("SELECT * FROM t_booking  WHERE room_number = :room_number AND kost_id = :kost_id", Booking.class)
                .setParameter("room_number", booking.getRoomNumber())
                .setParameter("kost_id", booking.getKost().getId())
                .getSingleResult();
    }
}
