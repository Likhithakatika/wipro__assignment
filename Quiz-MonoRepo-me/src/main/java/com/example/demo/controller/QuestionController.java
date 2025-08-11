package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Question;
import com.example.demo.services.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1")

public class QuestionController {

 
	private final QuestionService questionService ;
	

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@GetMapping("/hello") 
    public String sayHello() {
        return "  backend is working ";
    }

	@PostMapping("/saveQuestions")
	public Question create(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}

	@GetMapping("/getQuestionsById/{id}")
	public Question getById(@PathVariable long id) {
		return questionService.getQuestionById(id);
	}

	@GetMapping("/getAllQuestions")
	public List<Question> getAll() {
		return questionService.getAllQuestions();
	}

	@PatchMapping("/updateQuestion/{id}")
	public Question update(@PathVariable long id, @RequestBody Question question) {
		return questionService.updateQuestion(id, question);
	}

	@DeleteMapping("/deleteQuestionById/{id}")
	public String delete(@PathVariable long id) {
		questionService.deleteQuestion(id);
		return "Deleted Successfully";
	}
}
