package ru.anton.tester.backend.entity;

import ru.anton.tester.backend.service.AbstractEntity;

import javax.persistence.*;

@Entity
public class CorrectAnswer extends AbstractEntity {


    @Column(length = 2048)
    private String correctAnswer;



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

}
