package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Question;


public interface QuestionService {
	Question createQuestion(Question question);
    Question getQuestionById(long id);
    List<Question> getAllQuestions();
    Question updateQuestion(long id, Question question);
    void deleteQuestion(long id);
}