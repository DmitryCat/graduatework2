package com.example.Question.service.impl;

import com.example.Question.exception.TryToThrowMore;
import com.example.Question.model.Question;
import com.example.Question.service.ExaminerService;
import com.example.Question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new TryToThrowMore("В хранилище нет столько вопросов");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.qetRandomQuestion());
        }
        return questions;
    }
}
