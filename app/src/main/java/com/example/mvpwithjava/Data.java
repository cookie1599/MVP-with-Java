package com.example.mvpwithjava;

public class Data {
    private String text;

    public Data() {
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public interface View {
        void onAttachView();

        void onDetachView();
    }

    public interface Presenter<T extends View> {
        void onAttach(T view);

        void onDetach();
    }
