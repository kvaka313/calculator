package com.alexander.calculator.calculate;

import com.alexander.calculator.exception.CalculationException;
import com.alexander.calculator.exception.IncorrectExpression;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class CalculateExpressionTest {

    @Test
    public void testCalculate() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("123.23", "456.78", "+", "56", "-", "sqrt");
        double actual = calculateExpression.calculate(lexems);
        assertEquals(22.89, actual, 0.01);
    }

    @Test
    public void testCalculateTwoInputs() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("123.23", "456.78", "+", "56", "-", "sqrt");
        Double actual = calculateExpression.calculate(lexems);
        assertEquals(22.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("45"));
        assertEquals(45.00, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("+"));
        assertEquals(67.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("sqrt"));
        assertEquals(8.23, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("c"));
        assertNull(actual);
    }

    @Test(expected = IncorrectExpression.class)
    public void testCalculateTwoInputs_NotValidOperator() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("123.23", "456.78", "+", "56", "-", "sqrt");
        Double actual = calculateExpression.calculate(lexems);
        assertEquals(22.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("45"));
        assertEquals(45.00, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("+"));
        assertEquals(67.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("sqrtt"));
     }

    @Test(expected = CalculationException.class)
    public void testCalculateTwoInputs_IncorrectSequenceOperators() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("123.23", "456.78", "+", "-", "sqrt");
        Double actual = calculateExpression.calculate(lexems);
    }

    @Test(expected = CalculationException.class)
    public void testCalculateTwoInputs_IncorrectSequenceOperatorsInMultipleInput() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("123.23", "456.78", "+", "56", "-", "sqrt");
        Double actual = calculateExpression.calculate(lexems);
        assertEquals(22.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("45"));
        assertEquals(45.00, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("+"));
        assertEquals(67.89, actual, 0.01);
        actual = calculateExpression.calculate(Arrays.asList("-"));
    }

    @Test(expected = CalculationException.class)
    public void testCalculateTwoInputs_IncorrectSequenceUnitaryOperators() throws CalculationException, IncorrectExpression {
        CalculateExpression calculateExpression = new CalculateExpression();
        List<String> lexems = Arrays.asList("sqrt");
        Double actual = calculateExpression.calculate(lexems);
    }
}
