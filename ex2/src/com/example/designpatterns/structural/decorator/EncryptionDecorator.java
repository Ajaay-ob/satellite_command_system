package com.example.designpatterns.structural.decorator;

public class EncryptionDecorator implements DataSource {
    private DataSource wrappee;

    public EncryptionDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        String encrypted = "[encrypted]" + data;
        wrappee.writeData(encrypted);
    }
}
