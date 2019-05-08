package ru.toolkas.books.ui.view.main;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import ru.toolkas.books.ui.session.BookSession;
import ru.toolkas.books.ui.view.books.BookList;

public class Main extends MainDesign {
    public Main() {
        content2.addComponent(new BookList());
        books.addClickListener((Button.ClickListener) clickEvent -> {
            BookList list = new BookList();
            list.setSizeFull();
            content2.addComponent(list);
        });
        logout.addClickListener((Button.ClickListener) clickEvent -> {
            BookSession.logout(getSession());
            Page.getCurrent().reload();
        });
    }
}
