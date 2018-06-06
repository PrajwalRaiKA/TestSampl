package com.example.testsample;

public class SumUp {

    private SumUpService sumUpService;
    private SomoDto somoDto;

    public SumUp(SumUpService sumUpService, SomoDto somoDto) {
        this.sumUpService = sumUpService;
        this.somoDto = somoDto;
    }

    public int add(int i, int j) {
        return sumUpService.addInService(i, j);
    }


    public int callAddMultiple(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum = add(sum, intArray[i]);
        }
        return sum;
    }
}
