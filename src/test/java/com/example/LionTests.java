package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline mockFeline;

    @Test
    public void testMaleHasMane() throws Exception {

        when(mockFeline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", mockFeline);

        assertTrue(lion.doesHaveMane());
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testFemaleDoesNotHaveMane() throws Exception {

        when(mockFeline.getKittens()).thenReturn(0);

        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
        assertEquals(0, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Другое", mockFeline); // Ожидается исключение
    }

    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
