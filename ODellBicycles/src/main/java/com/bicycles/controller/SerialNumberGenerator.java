package com.bicycles.controller;

/* Implementing the Singleton Pattern */
public class SerialNumberGenerator {

    private static SerialNumberGenerator generate;
    private int startValue;
    private String prefixValue;

    public static synchronized SerialNumberGenerator getInstance() {
        if(generate == null) {
            generate = new SerialNumberGenerator();
        }
        return generate;
    }

    private SerialNumberGenerator() {}

    public synchronized void startGeneration(String model, int startNumber) {
        prefixValue = model;
        startValue = startNumber;
    }

    public synchronized String getNextSerial() {
        return prefixValue + (++startValue);
    }

    public synchronized int getRecentNumber() {
        return startValue;
    }

}
