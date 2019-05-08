package ru.toolkas.books.ui.view.login;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class Login extends VerticalLayout {
    public Login() {
        setSizeFull();
        setSpacing(false);
        setMargin(false);
        setStyleName("login");

        VerticalLayout layout = new VerticalLayout();
        layout.setWidth(350, Unit.PIXELS);
        layout.setMargin(false);
        layout.setStyleName("loginWindow");

        HorizontalLayout header = new HorizontalLayout();
        header.setSizeFull();

        Image logo = new Image();
        logo.setStyleName("logo");
        header.addComponent(logo);
        logo.setSource(new ThemeResource("images/logo.png"));
        logo.setWidth(32, Unit.PIXELS);
        logo.setHeight(32, Unit.PIXELS);
        layout.addComponent(header);
        header.setComponentAlignment(logo, Alignment.MIDDLE_LEFT);

        TextField login = new TextField();
        login.setStyleName("inline-icon");
        login.setPlaceholder("Логин пользователя");
        login.setIcon(VaadinIcons.USER);
        login.setSizeFull();
        layout.addComponent(login);

        PasswordField password = new PasswordField();
        password.setSizeFull();
        password.setStyleName("inline-icon");
        password.setPlaceholder("Пароль");
        password.setIcon(VaadinIcons.PASSWORD);
        layout.addComponent(password);

        Button button = new Button("ВХОД");
        button.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        button.setSizeFull();
        layout.addComponent(button);

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }
}
