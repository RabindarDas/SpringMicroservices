package com.question.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QusetionRepositories;
import com.question.services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QusetionRepositories qusetionRepositories;

	public QuestionServiceImpl(QusetionRepositories qusetionRepositories) {
		super();
		this.qusetionRepositories = qusetionRepositories;
	}

	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		return  qusetionRepositories.save(question);
	}

	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return qusetionRepositories.findAll();
	}

	@Override
	public Question getOne(Long id) {
		// TODO Auto-generated method stub
		return qusetionRepositories.findById(id).orElseThrow(()-> new RuntimeException("Question Not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return qusetionRepositories.findByQuizId(quizId);
	}

}
