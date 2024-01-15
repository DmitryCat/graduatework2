package com.example.Question;

import com.example.Question.model.Question;
import com.example.Question.service.QuestionService;
import com.example.Question.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    @Test
    public void testGetQuestions() {
        // Создаем mock для questionService
        QuestionService questionService = mock(QuestionService.class);

        // Создаем экземпляр ExaminerServiceImpl с mock questionService
        ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService);

        // Создаем некоторые тестовые вопросы
        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");

        // Задаем поведение для questionService.qetRandomQuestion()
        when(questionService.qetRandomQuestion()).thenReturn(question1, question2);

        // Устанавливаем вопросы в questionService
        when(questionService.getAll()).thenReturn(Set.of(question1, question2));

        // Вызываем метод, который мы хотим протестировать
        Collection<Question> result = examinerService.getQuestions(2);

        // Проверяем, что результат не пустой
        assertFalse(result.isEmpty());

        // Проверяем, что количество возвращенных вопросов соответствует ожидаемому
        assertEquals(2, result.size());

        // Проверяем, что возвращенные вопросы находятся внутри questionService
        assertTrue(questionService.getAll().containsAll(result));
    }
}
