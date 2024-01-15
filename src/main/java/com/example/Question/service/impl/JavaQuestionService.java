package com.example.Question.service.impl;

import com.example.Question.model.Question;
import com.example.Question.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {

    }
    @Override

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(new Question(question, answer));
        return question1;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question qetRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
