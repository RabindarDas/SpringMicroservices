package com.question.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionControlle {
	private QuestionService questionService;

	public QuestionControlle(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	@PostMapping
public Question create(@RequestBody Question question) {
	return questionService.create(question);
	
}
	@GetMapping
	public List<Question> getAll(){
		return questionService.get();
	}
	@GetMapping("/{questionId}")
	public Question getAll(@PathVariable Long questionId){
		return questionService.getOne(questionId);
		
	}
	@GetMapping("/quiz/{quizId}")
	public List<Question>getQuestionsOfQuiz(@PathVariable long quizId){
		return questionService.getQuestionsOfQuiz(quizId);
		
	}
}
