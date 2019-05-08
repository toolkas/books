package ru.toolkas.books.ui.session;

import com.vaadin.server.VaadinSession;

public class BookSession {
    public static boolean isLoggedIn(VaadinSession session) {
        if (session != null) {
            String name = (String) session.getAttribute(BookSession.class.getName());
            return name != null;
        }
        return false;
    }

    public static void login(VaadinSession session, String login) {
        session.setAttribute(BookSession.class.getName(), login);
    }

    public static void logout(VaadinSession session) {
        if (session != null) {
            session.setAttribute(BookSession.class.getName(), null);
            session.getSession().invalidate();
        }
    }
}
