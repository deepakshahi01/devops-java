package com.example.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAdd() {
        assertEquals(10.0, calculatorService.add(5, 5));
        assertEquals(0.0, calculatorService.add(-5, 5));
        assertEquals(-10.0, calculatorService.add(-5, -5));
    }

    @Test
    void testSubtract() {
        assertEquals(0.0, calculatorService.subtract(5, 5));
        assertEquals(-10.0, calculatorService.subtract(-5, 5));
        assertEquals(10.0, calculatorService.subtract(5, -5));
    }

    @Test
    void testMultiply() {
        assertEquals(25.0, calculatorService.multiply(5, 5));
        assertEquals(-25.0, calculatorService.multiply(-5, 5));
        assertEquals(0.0, calculatorService.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(1.0, calculatorService.divide(5, 5));
        assertEquals(2.5, calculatorService.divide(5, 2));
        assertEquals(-2.0, calculatorService.divide(-10, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(25.0, calculatorService.power(5, 2));
        assertEquals(8.0, calculatorService.power(2, 3));
        assertEquals(1.0, calculatorService.power(5, 0));
    }

    @Test
    void testSquareRoot() {
        assertEquals(5.0, calculatorService.squareRoot(25));
        assertEquals(0.0, calculatorService.squareRoot(0));
        assertEquals(3.0, calculatorService.squareRoot(9), 0.0001);
    }

    @Test
    void testSquareRootNegativeNumber() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.squareRoot(-25);
        });
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }
}
