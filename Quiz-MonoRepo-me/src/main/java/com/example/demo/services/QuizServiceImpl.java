package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Question;
import com.example.demo.entities.QuestionWrapper;
import com.example.demo.entities.Quiz;
import com.example.demo.entities.Response;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl {

    private final QuizRepository quizRepo ;
    private final QuestionRepository questionRepo ;

    public QuizServiceImpl(QuizRepository quizRepo, QuestionRepository questionRepo) {
		super();
		this.quizRepo = quizRepo;
		this.questionRepo = questionRepo;
	}

	public Quiz createQuiz(String category, String level, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategoryAndLevel(category, level);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        return quizRepo.save(quiz);
    }

    public QuizRepository getQuizRepo() {
		return quizRepo;
	}

	public QuestionRepository getQuestionRepo() {
		return questionRepo;
	}

	public List<QuestionWrapper> getQuizQuestions(Long id) {
        Quiz quiz = quizRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuestionWrapper> wrapperList = new ArrayList<QuestionWrapper>();
        List<Question> questions = quiz.getQuestions();

        for (Question q : questions) {
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            wrapperList.add(qw);
        }

        return wrapperList;
    }

    public Integer calculateResult(Long id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<Question> questions = quiz.getQuestions();
        int score = 0;

        for (Response response : responses) {
            for (Question question : questions) {
                if (question.getId().equals(response.getId())
                        && question.getCorrectAnswer().equalsIgnoreCase(response.getUserAnswer())) {
                    score++;
                    break;
                }
            }
        }

        return score;
    }

}
