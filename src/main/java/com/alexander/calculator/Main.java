package com.alexander.calculator;

import com.alexander.calculator.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        try {
            view.console();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
