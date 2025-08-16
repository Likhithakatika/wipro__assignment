
package com.example.booking.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private Long theaterId;
    private Long showId;
    private String seats;
    private Long userId;
    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getMovieId(){return movieId;}
    public void setMovieId(Long m){this.movieId=m;}
    public Long getTheaterId(){return theaterId;}
    public void setTheaterId(Long t){this.theaterId=t;}
    public Long getShowId(){return showId;}
    public void setShowId(Long s){this.showId=s;}
    public String getSeats(){return seats;}
    public void setSeats(String seats){this.seats=seats;}
    public Long getUserId(){return userId;}
    public void setUserId(Long u){this.userId=u;}
}
