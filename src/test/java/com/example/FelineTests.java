package com.example;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;


import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FelineTests {

    @Mock
    private Animal mockAnimal;

    @Test
    public void testEatMeat() throws Exception {

        MockitoAnnotations.initMocks(this);
        when(mockAnimal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));


        Feline feline = new Feline();
        feline.setAnimal(mockAnimal);


        List<String> actualResult = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualResult);
    }

    @Test
    public void testGetFamily() {

        Feline feline = new Feline();

        String actualResult = feline.getFamily();
        assertEquals("Кошачьи", actualResult);
    }

    @Test
    public void testGetKittensDefault() {

        Feline feline = new Feline();

        int actualResult = feline.getKittens();
        assertEquals(1, actualResult);
    }

    @Test
    public void testGetKittensWithParameter() {

        Feline feline = new Feline();

        int actualResult = feline.getKittens(3);
        assertEquals(3, actualResult);
    }
}
