package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedCatTest {

    @Parameterized.Parameters(name = "{index}: Cat with expected food={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {List.of("Животные", "Птицы", "Рыба")},
                {List.of("Мыши", "Птички")}
        });
    }

    @Parameterized.Parameter(0)
    public List<String> expectedFood;

    @Mock
    private Feline mockPredator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void parameterizedTestForGetFood() throws Exception {

        when(mockPredator.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockPredator);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }
}
