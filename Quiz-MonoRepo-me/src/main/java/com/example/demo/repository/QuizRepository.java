package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Quiz;


public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // No need to declare findById – inherited from JpaRepository
}