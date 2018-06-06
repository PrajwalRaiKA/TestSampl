package com.example.testsample;

public class AddClass implements CalculatorService {
    @Override
    public int add(int i, int j) {
        return i + j;
    }
}
