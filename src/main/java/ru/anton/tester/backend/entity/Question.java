package ru.anton.tester.backend.entity;

import ru.anton.tester.backend.service.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question extends AbstractEntity {



    @Column(length = 2048)
    private String question;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 2048)
    private List<String> testOptions;


    protected Question() {
    }

    public Question(String question, List<String> testOptions) {
        this.question = question;
        this.testOptions = testOptions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getTestOptions() {
        return testOptions;
    }

    public void setTestOptions(List<String> testOptions) {
        this.testOptions = testOptions;
    }

}

