package com.mars.back;

import com.mars.back.model.Operation;
import com.mars.back.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testAddition() {
        Operation operation = new Operation(1L, 5, 3, "+", 0);
        double result = calculatorService.calculate(operation);
        assertEquals(8, result);
    }
    @Test
    public void testSubtraction() {
        Operation operation = new Operation(2L, 5, 3, "-", 0);
        double result = calculatorService.calculate(operation);
        assertEquals(2, result);
    }
    @Test
    public void testMultiply() {
        Operation operation = new Operation(3L, 5, 3, "*", 0);
        double result = calculatorService.calculate(operation);
        assertEquals(15, result);
    }
    @Test
    public void testDivide() {
        Operation operation = new Operation(4L, 15, 3, "/", 0);
        double result = calculatorService.calculate(operation);
        assertEquals(5, result);
    }
}
