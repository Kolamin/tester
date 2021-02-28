package ru.anton.tester.view;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {


    QuestionForm questionForm;


    @Autowired
    public MainView(QuestionForm questionForm) {
        this.questionForm = questionForm;

        add(questionForm);

    }


}
