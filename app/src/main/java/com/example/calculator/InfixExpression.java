package com.example.calculator;

import java.util.Stack;

public class InfixExpression extends PostfixExpression{
    public InfixExpression(String expression) {
        super(expression);
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+': case '-': return 1;
            case '*': case '/': case '%': return 2;
            default: return -1; // Not an operator
        }
    }

    public String infixToPostfix(String expression) {
        //Shunting Yard algorithm
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                postfix.append(token).append(" ");
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                char operator = token.charAt(0);
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(operator)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(operator);
            }
            else if (token.equals("(")) {
                stack.push('(');
            }
            else if (token.equals(")")) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public String infixToPostfix() {
        return infixToPostfix(this.expression);
    }

    public double evaluate(String expression){
        return super.evaluate(infixToPostfix(expression));
    }
    public boolean isValid(String expression) {
        try {
            String postfix = infixToPostfix(expression);
            return super.isValid(postfix);
        } catch (Exception e) {
            return false;
        }
    }
}
