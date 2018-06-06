package com.example.testsample;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SumUpTest {

    SumUp sumUp;


    @Mock
    SumUpService sumUpService;
    @Mock
    SomoDto somoDto;

    @Before
    public void setUp() throws Exception {
        sumUp = new SumUp(sumUpService, somoDto);
    }

    @After
    public void tearDown() throws Exception {
        sumUp = null;
    }

    @Test
    public void addTest() {
        Mockito.when(sumUpService.addInService(Mockito.anyInt(), Mockito.anyInt())).thenReturn(8);
        sumUp.add(3, 5);
        Mockito.verify(somoDto).setSum(Mockito.anyInt());
        Mockito.verify(sumUpService).addInService(3, 5);
    }

    @Test
    public void checkSum() {
        int[] array = {2, 3, 5, 5, 6, 7, 8};
        Mockito.when(sumUpService.addInService(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
        int actual = sumUp.callAddMultiple(array);
        assertEquals(35,actual);
    }
}