package ru.anton.tester.view;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.anton.tester.backend.entity.CorrectAnswer;
import ru.anton.tester.backend.entity.Question;
import ru.anton.tester.backend.repository.CorrectAnswerRepository;
import ru.anton.tester.backend.repository.QuestionRepository;

import java.util.List;

@Route
public class MainView extends VerticalLayout {


    private final QuestionRepository questionRepository;
    private final CorrectAnswerRepository correctAnswerRepository;
    private Grid<Question> grid;

    @Autowired
    public MainView(QuestionRepository questionRepository, CorrectAnswerRepository correctAnswerRepository) {
        this.questionRepository = questionRepository;
        this.correctAnswerRepository = correctAnswerRepository;
        List<Question> all = questionRepository.findAll();

        List<CorrectAnswer> allAnswer = correctAnswerRepository.findAll();

//        for (Question question : all) {
//            add(new H3(question.getId() + "." + " " + question.getQuestion()));
//            for (String s : question.getTestOptions()) {
//                add(new Paragraph(s));
//            }
//        }

        for (CorrectAnswer correctAnswer : allAnswer) {
            add(new H3(correctAnswer.getId() + " " + correctAnswer.getCorrectAnswer()));
        }

    }


}
