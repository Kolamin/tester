package ru.anton.tester.view;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route
public class MainView extends VerticalLayout {

    public MainView() {

        Div menu = new Div();

        RouterLink testLink = new RouterLink("Г.2.1 Эксплуатация тепловых энергоустановок и тепловых сетей",
                QuestionForm.class);
        testLink.setHighlightCondition(HighlightConditions.sameLocation());
        menu.add(testLink);

        add(menu);

    }
}
