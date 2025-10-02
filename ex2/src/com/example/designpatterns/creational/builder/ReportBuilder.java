package com.example.designpatterns.creational.builder;

public class ReportBuilder {
    private String title;
    private String content;

    public ReportBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ReportBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public Report build() {
        return new Report(title, content);
    }
}
