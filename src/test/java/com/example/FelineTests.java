package com.example;


import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.Before;
import org.junit.Test;


public class FelineTests {

    private Feline feline;

    @Before
    public void initializeFeline() {
        feline = new Feline();
    }


    @Test
    public void testEatMeat() throws Exception {

        List<String> actualResult = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualResult);
    }

    @Test
    public void testGetFamily() {


        String actualResult = feline.getFamily();
        assertEquals("Кошачьи", actualResult);
    }

    @Test
    public void testGetKittensDefault() {


        int actualResult = feline.getKittens();
        assertEquals(1, actualResult);
    }

    @Test
    public void testGetKittensWithParameter() {
        

        int actualResult = feline.getKittens(3);
        assertEquals(3, actualResult);
    }
}
