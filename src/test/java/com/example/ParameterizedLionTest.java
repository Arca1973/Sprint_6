package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    @Parameterized.Parameters(name = "{index}: Lion with sex={0}, expected mane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedMane;

    @Mock
    private Feline mockFeline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockFeline.getKittens()).thenReturn(1);
    }

    @Test
    public void parameterizedTestForManePresence() throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedMane, lion.doesHaveMane()); // Проверяем наличие гривы согласно полу
    }

    @Test
    public void parameterizedTestForKittensCount() throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(1, lion.getKittens()); // Проверяем количество котят
    }
}
