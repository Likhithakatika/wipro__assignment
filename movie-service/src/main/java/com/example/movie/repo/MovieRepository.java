
package com.example.movie.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContainingIgnoreCase(String name);
}
