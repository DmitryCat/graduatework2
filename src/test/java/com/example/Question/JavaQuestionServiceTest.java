package com.example.Question;

import com.example.Question.model.Question;
import com.example.Question.service.QuestionService;
import com.example.Question.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.Collection;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JavaQuestionServiceTest {

    private JavaQuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question("Тестовый вопрос?", "Тестовый ответ");

        Question addedQuestion = questionService.add(question.getQuestion(), question.getAnswer());

        Assertions.assertEquals(question, addedQuestion);

        assertTrue(questionService.getAll().contains(question));
    }

    @Test
    public void testAddQuestionObject() {
        Question question = new Question("Тестовый вопрос?", "Тестовый ответ");

        Question addedQuestion = questionService.add(question);

        Assertions.assertEquals(question, addedQuestion);

        assertTrue(questionService.getAll().contains(question));
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question("Тестовый вопрос?", "Тестовый ответ");

        questionService.add(question);

        Question removedQuestion = questionService.remove(question);

        Assertions.assertEquals(question, removedQuestion);

        Assertions.assertFalse(questionService.getAll().contains(question));
    }

    @Test
    public void testGetAllQuestions() {
        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");

        questionService.add(question1);
        questionService.add(question2);

        Collection<Question> allQuestions = questionService.getAll();

        assertTrue(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
    }


    @Test
    public void shouldReturnRandomQuestion() {
        QuestionService questionService = new JavaQuestionService(); // Замените на ваш класс сервиса

        Question randomQuestion = questionService.qetRandomQuestion();

        assertNotNull(randomQuestion);
    }
}