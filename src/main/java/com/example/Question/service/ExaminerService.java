package com.example.Question.service;

import com.example.Question.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
