package com.wipro.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.example.entity.Question;
import com.wipro.example.entity.Question.DifficultyLevel;
import com.wipro.example.entity.QuestionWrapper;
import com.wipro.example.entity.Quiz;
import com.wipro.example.entity.Response;
import com.wipro.example.service.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/quiz")
@RestController
public class QuizController {
	
	private final QuizService quizService;
	
	@PostMapping("/create")
    public Quiz createQuiz(
            @RequestParam String difficultyLevel,
            @RequestParam String category,               
            @RequestParam String title) {
        return quizService.createQuiz(difficultyLevel, category, title);
    }
    
    
    
    @GetMapping("/getQuizByID/{id}")                  
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id){
        return quizService.getQuizQuestions(id);
    }
    
    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
    
   
}
