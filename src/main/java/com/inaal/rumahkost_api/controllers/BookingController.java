package com.inaal.rumahkost_api.controllers;

import com.inaal.rumahkost_api.models.dto.BookingDTO;
import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.models.response.SuccessResponse;
import com.inaal.rumahkost_api.services.BookingService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingService bookingService;
    private ModelMapper modelMapper;

    @Autowired
    public BookingController(BookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity getAllBookings() {
        List<Booking> bookings = bookingService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", bookings));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id) throws Exception {
        Booking booking = bookingService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", booking));
    }

    @PostMapping
    public ResponseEntity addBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        bookingService.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse("Success Created", booking));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBooking(@PathVariable Long id, @Valid @RequestBody BookingDTO bookingDTO) throws Exception {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        booking.setId(id);
        bookingService.update(booking);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success Updated",booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id) throws Exception {
        Booking booking = bookingService.findById(id);
        bookingService.delete(booking);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success Deleted", null));
    }

}
