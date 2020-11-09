package com.alexander.calculator.converter;

import com.alexander.calculator.exception.ParseLexemException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void testConvertToListLexem() throws ParseLexemException {
       Converter converter = new Converter();
       String input = "123.23   456.78   +       56   -        sqrt";
        List<String> actual = converter.convertToListLexem(input);
        List<String> expected = Arrays.asList("123.23", "456.78", "+", "56", "-", "sqrt");
        assertEquals(expected, actual);
    }

    @Test(expected = ParseLexemException.class)
    public void testConvertToListLexem_EmptyInputString() throws ParseLexemException {
        Converter converter = new Converter();
        String input = "";
        List<String> actual = converter.convertToListLexem(input);
    }

    @Test(expected = ParseLexemException.class)
    public void testConvertToListLexem_NullInputString() throws ParseLexemException {
        Converter converter = new Converter();
        String input = null;
        List<String> actual = converter.convertToListLexem(input);
    }

    @Test(expected = ParseLexemException.class)
    public void testConvertToListLexem_OnlySpaceInputString() throws ParseLexemException {
        Converter converter = new Converter();
        String input = " ";
        List<String> actual = converter.convertToListLexem(input);
    }
}
