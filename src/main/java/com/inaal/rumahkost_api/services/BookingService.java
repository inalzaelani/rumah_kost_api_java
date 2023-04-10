package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.exception.AlreadyExistException;
import com.inaal.rumahkost_api.exception.NotFoundException;
import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.models.entity.Kost;
import com.inaal.rumahkost_api.repositories.IBookingRepository;
import com.inaal.rumahkost_api.repositories.IRepositories;
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
    private IRepositories<Kost> kostRepository;

    @Autowired
    public BookingService(IBookingRepository<Booking> bookingRepository, IRepositories<Kost> kostRepository) {
        this.bookingRepository = bookingRepository;
        this.kostRepository = kostRepository;
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
            try {
                Booking bookings = bookingRepository.findById(id);
                return bookings;
            } catch (Exception e) {
                throw new NotFoundException("BOOKING NOT FOUND");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Booking booking) {
        try{
          try {
              Booking find = bookingRepository.findByRoomNumber(booking);
              Booking check = bookingRepository.findKostCapacity(booking.getId());
              if (find != null){
                  throw new AlreadyExistException("ROOM NUMBER ALREADY BOOKED");
              }
          }catch (NoResultException e){
              Kost kost = kostRepository.findById(booking.getKost().getId());
              Integer capacity= kost.getCapacity() - 1;
              if (capacity < 0){
                  throw new IndexOutOfBoundsException("KOST FULL");
              }else {
                  kost.setCapacity(capacity);
                  bookingRepository.save(booking);
              }
          }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Booking booking) throws Exception {
        try {
            try {
                Booking find = bookingRepository.findById(booking.getId());
                bookingRepository.delete(find);
            } catch (Exception e) {
                throw new NotFoundException("BOOKING NOT FOUND");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking booking) throws Exception {
        try {
            try {
                Booking find = bookingRepository.findById(booking.getId());
                bookingRepository.update(booking);
            } catch (Exception e) {
                throw new NotFoundException("BOOKING NOT FOUND");
            }

        } catch (Exception e) {
            throw new Exception("ID NOT FOUND");
        }
    }


}
