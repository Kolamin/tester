package ru.anton.tester.backend.entity;

import javax.persistence.*;

@Entity
public class CorrectAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 2048)
    private String correctAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String answer) {
        this.correctAnswer = answer;
    }

    protected CorrectAnswer() {
    }

    public CorrectAnswer( String answer) {
        this.correctAnswer = answer;
    }

    @Override
    public String toString() {
        return "CorrectAnswer{" +
                "id=" + id +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
