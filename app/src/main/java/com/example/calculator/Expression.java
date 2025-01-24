package com.example.calculator;

public abstract class Expression {
    protected String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    protected static double performOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return a / b;
            case '%':
                if (b == 0) {
                    throw new ArithmeticException("Mod by zero is not allowed");
                }
                return a % b;
            default:
                throw new IllegalArgumentException("Operator not supported: " + operator);
        }
    }
    protected static String stringFormatter(String expression){
        StringBuilder out = new StringBuilder();
        for(int i=0 ; i < expression.length() ; i++){
            char temp = expression.charAt(i);
            if(isOperator(temp) || temp == '(' || temp == ')'){
                out.append(" ").append(temp).append(" ");
            }else{
                out.append(temp);
            }
        }
        return out.toString().trim();
    }

    public void setExpression(String expression) {
        this.expression = stringFormatter(expression);
    }

    public String getExpression() {
        return expression;
    }

    public abstract boolean isValid(String expression);

    public abstract double evaluate(String expression);
    public abstract String toInfix(String expression);
}
