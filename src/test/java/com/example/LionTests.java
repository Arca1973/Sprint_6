package com.example;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline mockFeline;

    @Before
    public void setup() {
        when(mockFeline.getKittens()).thenReturn(1);
    }

    @Test
    public void testMaleHasMane() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testMaleGetKittens() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testFemaleDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testFemaleGetKittens() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertEquals(1, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Другое", mockFeline);
    }

    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
