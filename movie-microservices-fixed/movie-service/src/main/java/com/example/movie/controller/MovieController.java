
package com.example.movie.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.movie.model.Movie;
import com.example.movie.repo.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired MovieRepository repo;

    @PostMapping
    public Movie add(@RequestBody Movie m){ return repo.save(m); }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Movie> search(@RequestParam String q){
        return repo.findByNameContainingIgnoreCase(q);
    }

    @GetMapping
    public List<Movie> list(){ return repo.findAll(); }
}
