package com.alexander.calculator.converter;

import com.alexander.calculator.exception.ParseLexemException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Parser is class for parsing input line.
 */
public class Converter {

    public List<String> convertToListLexem(String input) throws ParseLexemException{
        if(StringUtils.isEmpty(input)) {
            throw new ParseLexemException("String can not be empty");
        }
        if(StringUtils.isEmpty(input.trim())) {
            throw new ParseLexemException("String can not be empty");
        }
        String inputWithoutSpaces = input.trim().replaceAll("\\s+", " ");
        String[] lexems = StringUtils.split(inputWithoutSpaces, " ");
        return Arrays.asList(lexems);
    }

}
