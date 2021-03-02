package ru.anton.tester.view;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {


    //QuestionForm questionForm;


    @Autowired
    public MainView() {
        // this.questionForm = questionForm;



        Div menu = new Div();

        RouterLink testLink = new RouterLink("Г.2.1 Эксплуатация тепловых энергоустановок и тепловых сетей",
                QuestionForm.class);
        testLink.setHighlightCondition(HighlightConditions.sameLocation());
        menu.add(testLink);

        add(menu);

    }
}
