package com.spel.demo;

import com.spel.demo.model.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
public class SpelSystemProp
{
    public static void main(String[] args)
    {
        User user = new User();
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext sysPropContext = new StandardEvaluationContext();
        //get context into var
        sysPropContext.setVariable("sysProperties", System.getProperties());

        Expression expName = parser.parseExpression("#sysProperties['user.name']");
        parser.parseExpression("name")
                .setValue(userContext, expName.getValue(sysPropContext));

        System.out.println(user.getName());
    }
}
