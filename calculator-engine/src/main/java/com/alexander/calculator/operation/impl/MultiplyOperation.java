package com.alexander.calculator.operation.impl;

import com.alexander.calculator.exception.CalculationException;
import com.alexander.calculator.operation.BinaryOperation;

public class MultiplyOperation extends BinaryOperation {
    private static final String SYMBOL = "*";

    @Override
    public boolean isEqual(String operation) {
        return SYMBOL.equalsIgnoreCase(operation);
    }

    @Override
    public Double calculate() throws CalculationException {
        if(leftOperand == null || rightOperand == null) {
            throw new CalculationException("Can not calculate expression. One of operand is equal zero");
        }
        return leftOperand * rightOperand;
    }
}
