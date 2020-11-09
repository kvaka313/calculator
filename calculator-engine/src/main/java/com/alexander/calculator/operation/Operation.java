package com.alexander.calculator.operation;

import com.alexander.calculator.exception.CalculationException;

public interface Operation {
    boolean isEqual(String operation);
    Double calculate() throws CalculationException;
}
