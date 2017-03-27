package com.google.evochko;

/**
 * I couldn't transform this class to bean,
 * because it's need to include javaee-api dependency
 <groupId>javax</groupId>
 <artifactId>javaee-api</artifactId>
 <version>7.0</version>
 *  In this case rest service can't parse url or NullPointer exception while bean creating.
 *  I think this is conflict of different versions of javaee-api - who khows.
 *  However I can make singleton rest service {@link com.google.evochko.ApplicationConfig}
 */
//@Singleton
public class MathExpressionSingletonBean {
    private String expression;

    public MathExpressionSingletonBean() {
        this("(x1+x2)/2");
    }

    public MathExpressionSingletonBean(String e) {
        expression = e;
    }

//    @PostConstruct
//    public void onStartup() {
//        expression = "(x1+x2)/2";
//    }

    public String getExpression() {
        return expression;
    }

    public synchronized void setExpression(String expression) {
        this.expression = expression;
    }
}
