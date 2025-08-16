
package com.example.movie.model;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private int yearOfRelease;
    // getters & setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name;}
    public void setName(String name){ this.name = name;}
    public String getGenre(){ return genre;}
    public void setGenre(String genre){ this.genre = genre;}
    public int getYearOfRelease(){ return yearOfRelease;}
    public void setYearOfRelease(int y){ this.yearOfRelease = y;}
}
