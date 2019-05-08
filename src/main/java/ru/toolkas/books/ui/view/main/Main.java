package ru.toolkas.books.ui.view.main;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import ru.toolkas.books.ui.session.BookSession;

public class Main extends MainDesign {
    public Main() {
        logout.addClickListener((Button.ClickListener) clickEvent -> {
            BookSession.logout(getSession());
            Page.getCurrent().reload();
        });
    }
}
