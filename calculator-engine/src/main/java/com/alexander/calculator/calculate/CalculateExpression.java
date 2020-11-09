package com.alexander.calculator.calculate;

import com.alexander.calculator.exception.CalculationException;
import com.alexander.calculator.exception.IncorrectExpression;
import com.alexander.calculator.operation.BinaryOperation;
import com.alexander.calculator.operation.Operation;
import com.alexander.calculator.operation.UnitaryOperation;
import com.alexander.calculator.operation.impl.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CalculateExpression {
    private static final String CLEAR = "c";
    private Deque<Double> output = new ArrayDeque<>();
    private List<Operation> operations;

    public CalculateExpression(){
        operations = new ArrayList<>();
        operations.add(new PlusOperation());
        operations.add(new MinusOperation());
        operations.add(new MultiplyOperation());
        operations.add(new DividedOperation());
        operations.add(new SqrtOperation());
     }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public Double calculate(List<String> lexems) throws IncorrectExpression, CalculationException {
        for (String lexem: lexems) {
            if(CLEAR.equals(lexem)) {
                output.clear();
                continue;
            }

            if(isNumeric(lexem)) {
                output.addFirst(Double.valueOf(lexem.trim()));
                continue;
            }

            Operation operation = getOperation(lexem);
            if(operation.getClass().getSuperclass() == UnitaryOperation.class) {
                UnitaryOperation unitaryOperation = (UnitaryOperation) operation;
                unitaryOperation.setOperand(output.pollFirst());
                output.addFirst(unitaryOperation.calculate());
                unitaryOperation.clear();
                continue;
            }

            if(operation.getClass().getSuperclass() == BinaryOperation.class) {
                BinaryOperation binaryOperation = (BinaryOperation) operation;
                binaryOperation.setRightOperand(output.pollFirst());
                binaryOperation.setLeftOperand(output.pollFirst());
                output.addFirst(binaryOperation.calculate());
                binaryOperation.clear();
                continue;
            }
        }
        if(output.size() == 0) {
            return null;
        }
        return output.getFirst();
    }

    private Operation getOperation(String lexem) throws IncorrectExpression{
        for(Operation operation:operations) {
            if(operation.isEqual(lexem)) {
                return operation;
            }
        }
        throw new IncorrectExpression(String.format("Operation %s is invalid", lexem));
    }

    private boolean isNumeric(String lexem) {
        try {
            Double.parseDouble(lexem);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
