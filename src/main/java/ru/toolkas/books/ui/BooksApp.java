package ru.toolkas.books.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import ru.toolkas.books.ui.session.BookSession;
import ru.toolkas.books.ui.view.login.Login;
import ru.toolkas.books.ui.view.main.Main;

import java.util.Objects;

@Theme("mytheme")
public class BooksApp extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Page.getCurrent().setTitle("Библиотека");

        if (BookSession.isLoggedIn(getSession())) {
            Main main = new Main();
            setContent(main);
        } else {
            Login login = new Login(credentials -> {
                if (Objects.equals("admin", credentials.getLogin()) && Objects.equals("111", credentials.getPassword())) {
                    setContent(new Main());
                } else {
                    new Notification("неверный логин или пароль", Notification.Type.WARNING_MESSAGE).show(Page.getCurrent());
                }
            });
            setContent(login);
        }
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = BooksApp.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
