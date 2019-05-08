package ru.toolkas.books.ui.view.login;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;

import java.util.function.Consumer;

public class Login extends VerticalLayout {
    private static final Logger LOGGER = Logger.getLogger(Login.class);

    public Login(Consumer<Credentials> onLogin) {
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


        Binder<Credentials> binder = new Binder<>(Credentials.class);
        binder.forField(login).withValidator(new StringLengthValidator("Введите логин", 1, 100)).bind(Credentials::getLogin, Credentials::setLogin);
        binder.forField(password).withValidator(new StringLengthValidator("Введите пароль", 1, 100)).bind(Credentials::getPassword, Credentials::setPassword);

        Button button = new Button("ВХОД", (Button.ClickListener) clickEvent -> {
            try {
                if (binder.validate().isOk()) {
                    Credentials credentials = new Credentials();
                    binder.writeBean(credentials);

                    onLogin.accept(credentials);
                }
            } catch (ValidationException ex) {
                LOGGER.error(ex.getMessage(), ex);
                new Notification(String.format("Произошла ошибка: %s", ex.getMessage()), Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
            }
        });
        button.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        button.setSizeFull();
        layout.addComponent(button);

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);


    }
}
