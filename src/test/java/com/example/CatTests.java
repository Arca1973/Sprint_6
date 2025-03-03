package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline mockFeline;

    @Test
    public void testGetSound() {

        Cat cat = new Cat(mockFeline);
        assertEquals("Ожидается, что кошка должна мяукать \"Мяу\", но получено другое значение.", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {

        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(mockFeline);
        List<String> actualFood = cat.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actualFood);
    }
}
