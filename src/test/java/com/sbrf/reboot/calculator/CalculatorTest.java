package com.sbrf.reboot.calculator;

import com.sbrf.reboot.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void getAdditionWhenNumbersAreInt() {
        assertEquals(9, new Calculator().getAddition(4, 5));
    }

    @Test
    void getAdditionWhenNumbersAreDouble() {
        assertEquals(5.4, new Calculator().getAddition(2.2, 3.2));
    }

    @Test
    void getAdditionWhenNumbersAreMixed() {
        assertEquals(5.2, new Calculator().getAddition(2, 3.2));
    }

    @Test
    void getSubtractionWhenNumbersAreInt() {
        assertEquals(-1, new Calculator().getSubtraction(4, 5));
    }

    @Test
    void getSubtractionWhenNumbersAreDouble() {
        assertEquals(-3, new Calculator().getSubtraction(5.5, 8.5));
    }

    @Test
    void getSubtractionWhenNumbersAreMixed() {
        assertEquals(-3.5, new Calculator().getSubtraction(5, 8.5));
    }

    @Test
    void getMultiplicationWhenNumbersAreInt() {
        assertEquals(20, new Calculator().getMultiplication(4, 5));
    }

    @Test
    void getMultiplicationWhenNumbersAreDouble() {
        assertEquals(2.4, new Calculator().getMultiplication(2.4, 1.0));
    }

    @Test
    void getMultiplicationWhenNumbersAreMixed() {
        assertEquals(2.4, new Calculator().getMultiplication(2, 1.2));
    }

    @Test
    void getDivisionWhenNumbersAreInt() {
        assertEquals(3, new Calculator().getDivision(9, 3));
    }

    @Test
    void getDivisionWhenNumbersAreDouble() {
        assertEquals(2.5, new Calculator().getDivision(5.0, 2.0));
    }

    @Test
    void getDivisionWhenNumbersAreMixed() {
        assertEquals(2.5, new Calculator().getDivision(5, 2.0));
    }

    @Test
    void getExponentiationWhenNumbersAreInt() {
        assertEquals(8, new Calculator().getExponentiation(2, 3));
    }

    @Test
    void getExponentiationWhenNumbersAreDouble() {
        assertEquals(2, new Calculator().getExponentiation(4.0, 0.5));
    }

    @Test
    void getExponentiationWhenNumbersAreMixed() {
        assertEquals(2, new Calculator().getExponentiation(4, 0.5));
    }

    @Test
    void getNthRootWhenNumbersAreInt() {
        assertEquals(2, new Calculator().getNthRoot(4, 2));
    }

    @Test
    void getNthRootWhenNumbersAreDouble() {
        assertEquals(1.2, new Calculator().getNthRoot(1.44, 2.0));
    }

    @Test
    void getNthRootWhenNumbersAreMixed() {
        assertEquals(1.2, new Calculator().getNthRoot(1.44, 2));
    }

    @Test
    void getLogarithmWhenNumbersAreInt() {
        assertEquals(3, new Calculator().getLogarithm(8, 2));
    }

    @Test
    void getLogarithmWhenNumbersAreIntButAnswerIsDouble() {
        assertEquals(1.464973520717927, new Calculator().getLogarithm(5, 3));
    }

    @Test
    void getLogarithmWhenNumbersAreDouble() {
        assertEquals(2, new Calculator().getLogarithm(1.0201, 1.01));
    }

    @Test
    void getLogarithmWhenNumbersAreMixed() {
        assertEquals(2, new Calculator().getLogarithm(9, 3.0));
    }

    @Test
    void classHasSevenMethods() {
        assertEquals(7, Calculator.class.getMethods().length - Object.class.getMethods().length);
    }
}