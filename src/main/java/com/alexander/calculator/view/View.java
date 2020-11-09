package com.alexander.calculator.view;

import com.alexander.calculator.calculate.CalculateExpression;
import com.alexander.calculator.converter.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    public void console() throws IOException {
        CalculateExpression calculateExpression = new CalculateExpression();
        Converter converter = new Converter();
        System.out.print(">");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while(!input.trim().equals("q")) {
            try {
                Double result = calculateExpression.calculate(converter.convertToListLexem(input));
                if(result != null) {
                    System.out.println(result.doubleValue());
                } else {
                    System.out.println("null");
                }

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print(">");
            input = reader.readLine();
        }
    }
}
