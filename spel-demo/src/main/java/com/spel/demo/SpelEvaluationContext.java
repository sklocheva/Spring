package com.spel.demo;

import com.spel.demo.model.User;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
public class SpelEvaluationContext
{
    public static void main(String[] args)
    {
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext ec = new StandardEvaluationContext();

        ec.setVariable("greeting", "Hello");
        String msg = (String) parser.parseExpression("#greeting").getValue(ec);
        System.out.println(msg);

        ec.setVariable("greeting", "Hello World");
        String msg2 = (String) parser.parseExpression("#greeting.substring(6)").getValue(ec);
        System.out.println(msg2);


        User user = new User();
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);

        parser.parseExpression("country").setValue(userContext, "US");
        System.out.println(user.getCountry());

        parser.parseExpression("name").setValue(userContext, "John");
        parser.parseExpression("language").setValue(userContext, "English");

        System.out.println(user);

    }
}
