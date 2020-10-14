package com.spel.demo;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
public class SpelExpressionParsers
{
    public static void main(String[] args)
    {
        org.springframework.expression.spel.standard.SpelExpressionParser parser = new org.springframework.expression.spel.standard.SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");

        Expression expOper = parser.parseExpression("'Hello World'.length()*10");

        String message = (String) exp.getValue();
        System.out.println(message);
        System.out.println(expOper.getExpressionString() + " => " + expOper.getValue());
    }
}
