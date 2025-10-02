package com.example.designpatterns.creational.builder;

public class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "[Builder] Report: " + title + " - " + content;
    }
}
