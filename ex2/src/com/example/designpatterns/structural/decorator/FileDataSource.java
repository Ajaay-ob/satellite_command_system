package com.example.designpatterns.structural.decorator;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("[Decorator] Writing data to file " + filename + ": " + data);
    }
}
