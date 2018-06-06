package com.example.testsample;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
public class CalculatorTest {
    private Calculator calculator;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    AddClass addClass;

    @Mock
    SomoDto somoDto;


    @Before
    public void setUp()  {
//        addClass = Mockito.mock(AddClass.class);
        calculator = new Calculator(addClass, somoDto);
    }

    @After
    public void tearDown(){
        calculator = null;
    }

    @Test
    public void addTest() {
        float delta = 1f;
        Mockito.when(addClass.add(3, 3)).thenReturn(6);
        calculator.perform(3, 3);
//        assertEquals(5, actualresult, delta);

        Mockito.verify(addClass).add(3, 3);
        Mockito.verify(somoDto).setSum(6);

        assertEquals(6, somoDto.getSum());
    }

    /*@Test
    public void addTest1() {
        float delta = 0.1f;
        Mockito.when(addClass.add(2, 3)).thenReturn(6);
        int actualresult = calculator.perform(2, 3);
        assertEquals(6, actualresult, delta);
    }*/
}