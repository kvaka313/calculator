package com.alexander.calculator.operation.impl;

import com.alexander.calculator.exception.CalculationException;
import com.alexander.calculator.operation.UnitaryOperation;

public class SqrtOperation extends UnitaryOperation {
    private static final String SYMBOL = "sqrt";

    @Override
    public boolean isEqual(String operation) {
        return SYMBOL.equalsIgnoreCase(operation);
    }

    @Override
    public Double calculate() throws CalculationException {
        if(operand == null) {
            throw new CalculationException("Can not calculate expression. Operand is equal zero");
        }
        return Math.sqrt(operand);
    }
}
