package com.example.designpatterns.structural.decorator;

public class CompressionDecorator implements DataSource {
    private DataSource wrappee;

    public CompressionDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        String compressed = "[compressed]" + data;
        wrappee.writeData(compressed);
    }
}
