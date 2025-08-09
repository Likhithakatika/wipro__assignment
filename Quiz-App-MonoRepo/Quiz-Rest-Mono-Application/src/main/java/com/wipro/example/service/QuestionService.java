package com.wipro.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.example.entity.Question;
import com.wipro.example.entity.Question.Category;

@Service
public interface QuestionService {

	Question save(Question question);

	List<Question> findAllQuestions();

	Question findQuestionById(Long id);

	Question updateQuestionById(Long id, Question question);

	void deleteQuestionById(Long id);

	Question patchQuestionById(Long id, Question question);

	List<Question> getQuestionsByCategory(Category category);

	

}
