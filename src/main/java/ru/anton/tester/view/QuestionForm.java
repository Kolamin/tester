package ru.anton.tester.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.anton.tester.backend.entity.Question;
import ru.anton.tester.backend.repository.CorrectAnswerRepository;
import ru.anton.tester.backend.repository.QuestionRepository;

import java.util.List;

@SpringComponent
@UIScope
public class QuestionForm extends VerticalLayout {


    private final QuestionRepository questionRepository;

    private final CorrectAnswerRepository correctAnswerRepository;

    List<Question> allQuestion;
    Button btnAnswer;
    Button btnNextQuestion;
    H3 nameQuestion;
    RadioButtonGroup<String> radioTestOptions;
    long ID = 1;


    @Autowired
    public QuestionForm(QuestionRepository questionRepository, CorrectAnswerRepository correctAnswerRepository) {

        this.questionRepository = questionRepository;
        this.correctAnswerRepository = correctAnswerRepository;

        btnAnswer = new Button("Ответить");
        btnNextQuestion = new Button("Следующий вопрос");

        allQuestion = questionRepository.findAll();



        add(createQuestionLayout(ID), createButtonLayout());


    }

    public void setID(long id) {
        this.ID = id;
    }


    private VerticalLayout createQuestionLayout(long ID) {
        //this.ID = ID;
        radioTestOptions = new RadioButtonGroup<>();
        nameQuestion = new H3(questionRepository.findById(ID)
                .getId() + ". " + questionRepository.findById(ID)
                .getQuestion());
        radioTestOptions.setItems(questionRepository.findById(ID)
                .getTestOptions());
        return new VerticalLayout(nameQuestion, radioTestOptions);

    }


    private HorizontalLayout createButtonLayout() {

        btnNextQuestion.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnAnswer.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        return new HorizontalLayout(btnNextQuestion, btnAnswer);
    }
}
