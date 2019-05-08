package ru.toolkas.books.ui.view.main;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Main extends VerticalLayout {
    public Main() {
        addComponent(new Label("Тут будут книги"));
    }
}
