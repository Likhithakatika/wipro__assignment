
package com.example.review.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.review.model.Review;
import com.example.review.repo.ReviewRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired ReviewRepository repo;

    @PostMapping
    public Review add(@RequestBody Review r){ return repo.save(r); }

    @GetMapping
    public List<Review> list(@RequestParam Long entityId, @RequestParam String entityType){
        return repo.findByEntityIdAndEntityType(entityId, entityType);
    }
}
