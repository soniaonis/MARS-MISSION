package com.mars.back.service;

import com.mars.back.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculate(Operation operation) {
        int operand1 = operation.getOperand1();
        int operand2 = operation.getOperand2();
        String operator = operation.getOperator();

        return switch (operator) {
            case "+" -> add(operand1, operand2);
            case "-" -> subtract(operand1, operand2);
            case "*" -> multiply(operand1, operand2);
            case "/" -> divide(operand1, operand2);
            default -> throw new IllegalArgumentException("Operator not valid: " + operator);
        };
    }

    private int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int divide(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Division by zero not allowed");
        }
        return operand1 / operand2;
    }

    public void saveResult(Operation operation, int result) {
        operation.setResult(result);
    }

    public void deleteOperationById(Long id) {
    }
}
