
package com.example.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.booking.repo.BookingRepository;
import com.example.booking.model.Booking;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired BookingRepository repo;
    @Autowired RestTemplate rest;

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody Map<String,Object> body){
        Long movieId = Long.valueOf(body.get("movieId").toString());
        Long theaterId = Long.valueOf(body.get("theaterId").toString());
        Long showId = Long.valueOf(body.get("showId").toString());
        int seats = Integer.parseInt(body.getOrDefault("seats", 1).toString());

        // reserve seat (call theater service directly via localhost for simplicity)
        String reserveUrl = "http://localhost:8082/theaters/" + theaterId + "/shows/" + showId + "/reserve";
        Map<String,Object> req = Map.of("seats", seats);
        String res = rest.postForObject(reserveUrl, req, String.class);
        if(!"reserved".equals(res)) return ResponseEntity.badRequest().body(Map.of("error", "could-not-reserve", "reason", res));

        Booking b = new Booking();
        b.setMovieId(movieId); b.setTheaterId(theaterId); b.setShowId(showId);
        b.setSeats(Integer.toString(seats));
        b.setUserId(Long.valueOf(body.getOrDefault("userId", 0).toString()));
        Booking saved = repo.save(b);

        // notify (simple)
        try {
            String notifyUrl = "http://localhost:8084/notify";
            rest.postForObject(notifyUrl, Map.of("bookingId", saved.getId(), "userId", saved.getUserId()), String.class);
        } catch(Exception e){}

        return ResponseEntity.ok(saved);
    }
}
