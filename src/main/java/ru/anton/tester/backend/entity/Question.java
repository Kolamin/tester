package ru.anton.tester.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", testOptions=" + testOptions +
                '}';
    }
}

