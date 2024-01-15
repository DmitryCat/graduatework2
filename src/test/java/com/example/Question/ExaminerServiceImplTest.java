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
        QuestionService questionService = mock(QuestionService.class);
        ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService);
        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");
        when(questionService.qetRandomQuestion()).thenReturn(question1, question2);
        when(questionService.getAll()).thenReturn(Set.of(question1, question2));
        Collection<Question> result = examinerService.getQuestions(2);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(questionService.getAll().containsAll(result));
    }
}
