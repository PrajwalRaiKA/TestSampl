package com.example.testsample;

public class Calculator {

    private AddClass addition;
    private SomoDto obj;

    public Calculator(AddClass service, SomoDto obj) {
        addition = service;
        this.obj = obj;
    }

    public int perform(int i, int j) {
        return i + j;
    }
}
