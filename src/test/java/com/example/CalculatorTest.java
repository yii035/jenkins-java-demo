package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addShouldReturnSum() {
        assertEquals(, calc.add(2, 3));
    }

    @Test
    void subtractShouldReturnDifference() {
        assertEquals(6, calc.subtract(10, 4));
    }

    @Test
    void multiplyShouldReturnProduct() {
        assertEquals(42, calc.multiply(6, 7));
    }

    @Test
    void divideShouldReturnQuotient() {
        assertEquals(4, calc.divide(20, 5));
    }

    @Test
    void divideByZeroShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }
}
