package ru.toolkas.books.search.recognition;

import java.io.File;

public class Tika {
    private String url;

    public Tika(String url) {
        this.url = url;
    }

    public String getText(File file, String mimeType) {
        throw new UnsupportedOperationException();
    }
}
