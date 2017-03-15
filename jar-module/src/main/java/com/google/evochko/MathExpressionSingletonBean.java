package com.google.evochko;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
@LocalBean
public class MathExpressionSingletonBean {
    private String expression;

    public MathExpressionSingletonBean() {
        expression = "(x1+x2)/2";
    }

    @PostConstruct
    public void onStartup() {
        expression = "(x1+x2)/2";
    }

    public String getExpression() {
        return expression;
    }

    public synchronized void setExpression(String expression) {
        this.expression = expression;
    }
}
