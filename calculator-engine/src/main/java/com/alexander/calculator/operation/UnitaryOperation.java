package com.alexander.calculator.operation;

public abstract class UnitaryOperation implements Operation {
    protected Double operand;

    public UnitaryOperation(){}

    public void setOperand(Double operand) {
        this.operand = operand;
    }

    public void clear() {
        operand = null;
    }
}
