package com.alexander.calculator.operation;

public abstract class BinaryOperation implements Operation {
    protected Double leftOperand;
    protected Double rightOperand;
    public BinaryOperation(){}


    public void setLeftOperand(Double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setRightOperand(Double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public void clear() {
        leftOperand = null;
        rightOperand = null;
    }

}
