package com.wipro.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.example.entity.Question;
import com.wipro.example.entity.Question.Category;
import com.wipro.example.entity.Question.DifficultyLevel;
import com.wipro.example.entity.QuestionWrapper;
import com.wipro.example.entity.Quiz;
import com.wipro.example.entity.Response;
import com.wipro.example.repo.QuestionRepository;
import com.wipro.example.repo.QuizRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {
	
	private final QuizRepository quizRepository;
	private final QuestionRepository questionRepository;

	
	@Override
	public Quiz createQuiz(String difficultyLevel, String category, String title) {
		List<Question> questions = questionRepository.findRandomQuestionsByCategoryAndDifficultyLevel(difficultyLevel, category);
		
		Quiz quiz = new Quiz();
	    quiz.setTitle(title);
	    quiz.setQuestions(questions);
	    return quizRepository.save(quiz);
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(Long id) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		
		List<Question> questionDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		return questionsForUser;
	}

	@Override
	public Integer calculateResult(Long id, List<Response> responses) {
		 Quiz quiz = quizRepository.findById(id).get();
	        List<Question> questions = quiz.getQuestions();
	        int rightAnswerScore = 0;

	        for (Response response : responses) {
	            for (Question question : questions) {
	                if (question.getId() == response.getId()) {
	                    if (question.getCorrectAnswer().equalsIgnoreCase(response.getResponse())) {
	                    	rightAnswerScore++;
	                    }
	                    break; // no need to keep checking once matched
	                }
	            }
	        }
		return rightAnswerScore;
	}

	

	

/*
	@Override
	public Quiz createQuiz(String category, String level, String title) {
		 List<Question> questions = questionRepository.findRandomQuestionsByCategoryAndDifficultyLevel(difficultyLevel, category);

		    Quiz quiz = new Quiz();
		    quiz.setTitle(title);
		    quiz.setQuestions(questions);

		    return quizRepository.save(quiz);
	} */


	

	


	





	

}
