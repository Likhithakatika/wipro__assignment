package com.wipro.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.example.entity.Question;
import com.wipro.example.entity.Question.Category;
import com.wipro.example.exceptions.QuestionNotFoundException;
import com.wipro.example.repo.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionRepository questionRepo;

	@Override
	public Question save(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public List<Question> findAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public Question findQuestionById(Long id) {
		return questionRepo.findById(id).get();
	}

	@Override
	public Question updateQuestionById(Long id, Question question) {
		Question existedQuestion = questionRepo.findById(id).
				orElseThrow(()-> new QuestionNotFoundException("Question not found with that Id" + id));
		
		existedQuestion.setQuestion(question.getQuestion());
		existedQuestion.setOption1(question.getOption1());
		existedQuestion.setOption2(question.getOption2());
		existedQuestion.setOption3(question.getOption3());
		existedQuestion.setOption4(question.getOption4());
		existedQuestion.setCorrectAnswer(question.getCorrectAnswer());
		existedQuestion.setDifficultyLevel(question.getDifficultyLevel());
		existedQuestion.setCategory(question.getCategory());
		
		return questionRepo.save(existedQuestion);
		
	}

	@Override
	public void deleteQuestionById(Long id) {
		questionRepo.deleteById(id);
	}

	@Override
	public Question patchQuestionById(Long id, Question question) {
		Question existedQuestion = questionRepo.findById(id).
				orElseThrow(()-> new QuestionNotFoundException("Question not found with that Id" + id));
		if(question.getQuestion()!=null) {
			existedQuestion.setQuestion(question.getQuestion());
		}
		if(question.getOption1()!=null) {
			existedQuestion.setOption1(question.getOption1());
		}
		if(question.getOption2()!=null) {
			existedQuestion.setOption2(question.getOption2());
		}
		if(question.getOption3()!=null) {
			existedQuestion.setOption3(question.getOption3());
		}
		if(question.getOption4()!=null) {
			existedQuestion.setOption4(question.getOption4());
		}
		if(question.getCorrectAnswer()!=null) {
			existedQuestion.setCorrectAnswer(question.getCorrectAnswer());
		}
		if(question.getDifficultyLevel()!=null) {
			existedQuestion.setDifficultyLevel(question.getDifficultyLevel());
		}
		if(question.getCategory()!=null) {
			existedQuestion.setCategory(question.getCategory());
		}
		return questionRepo.save(existedQuestion);
	}

	@Override
	public List<Question> getQuestionsByCategory(Category category) {
		// TODO Auto-generated method stub
		return questionRepo.findByCategory(category);
	}
	

	
	

}
