package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.exception.NotFoundException;
import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.repositories.IBookingRepository;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@Transactional
public class BookingService implements IBookingService<Booking> {

    private IBookingRepository<Booking> bookingRepository;

    @Autowired
    public BookingService(IBookingRepository<Booking> bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .findFirst()
                .map(b -> bookings)
                .orElseThrow(() -> new NotFoundException("BOOKING NOT FOUND"));
    }


    @Override
    public Booking findById(Long id) throws Exception {
        try {
            Booking bookings = bookingRepository.findById(id);
            if (bookings == null) {
                throw new NotFoundException("BOOKING NOT FOUND");
            }
            return bookings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Booking booking) {
        try{
          try {
              Booking find = bookingRepository.findByRoomNumber(booking);
              if (find != null){
                  throw new NotFoundException("ROOM NUMBER ALREADY BOOKED");
              }
          }catch (NoResultException e){
              bookingRepository.save(booking);
          }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Booking booking) throws Exception {
        try {
            Booking find = bookingRepository.findById(booking.getId());
            if (find == null) {
                throw new NotFoundException("BOOKING NOT FOUND");
            } else {
                bookingRepository.delete(booking);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking booking) throws Exception {
        try {
            Booking find = bookingRepository.findById(booking.getId());

            if (find == null) {
                throw new NotFoundException("BOOKING NOT FOUND");
            } else {
                bookingRepository.save(booking);
            }
        } catch (Exception e) {
            throw new Exception("ID NOT FOUND");
        }
    }


}
