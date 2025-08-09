package com.wipro.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.example.entity.Question;
import com.wipro.example.entity.Question.Category;
import com.wipro.example.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/question")
@RestController
public class QuestionController {
	
	private final QuestionService questionService;
	
	@PostMapping("/addNewQuestion")
	public Question addNewQuestion(@Valid @RequestBody Question question) {
		return questionService.save(question);
	}
	
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions(){
		return questionService.findAllQuestions();
	}
	
	@GetMapping("/getQuestionById/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		return questionService.findQuestionById(id);
	}
	
	@PutMapping("/updateQuestion/{id}")
	public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
		return questionService.updateQuestionById(id, question);
	}
	
	@DeleteMapping("/deleteQuestionById/{id}")
	public void deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestionById(id);
	}
	
	@PatchMapping("/patchQuestion/{id}")
	public Question patchQuestion(@PathVariable Long id, @RequestBody Question question) {
		return questionService.patchQuestionById(id, question);
	}
	
	@GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable Category category){
        return questionService.getQuestionsByCategory(category);
    }
}