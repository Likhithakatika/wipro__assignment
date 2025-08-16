
package com.example.review.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.review.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByEntityIdAndEntityType(Long entityId, String entityType);
}
