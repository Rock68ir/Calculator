package com.example.calculator;
import java.util.*;

public class PrefixExpression extends Expression{
    public PrefixExpression(String expression) {
        super(expression);
    }

    public boolean isValid(String expression) {

        String[] tokens = expression.split("\\s+");

        Stack<String> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(token);
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    return false;
                }
                stack.pop();
                stack.pop();
                stack.push("temp");
            }
            else {
                return false;
            }
        }
        return stack.size() == 1;
    }

    public boolean isValid() {

        return isValid(this.expression);
    }

    public String toInfix(String expression) {
        String[] tokens = expression.split("\\s+"); // Split by spaces
        Stack<String> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(token);
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String subExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(subExpression);
            }
            else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        return stack.pop();
    }
    public double evaluate(String expression) {
        String[] tokens = expression.split("\\s+");
        Stack<Double> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double result = performOperation(operand1, operand2, token.charAt(0));
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public double evaluate() {
        return evaluate(this.expression);
    }

    public String toInfix() {
        return toInfix(this.expression);
    }
}
