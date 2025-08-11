package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question WHERE category = ?1 AND difficulty_level = ?2 ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestionsByCategoryAndLevel(String category, String difficultyLevel);
}