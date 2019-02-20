package com.example.math;

public class ExpressionNode {

    public static boolean IsOperator(char c) {
        return (c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/');
    }

    public enum NodeType {
        Number, Operator
    }

    public NodeType nodeType;
    public char nodeValue;
    public double numericalValue;
    public ExpressionNode left;
    public ExpressionNode right;

    public double ApplyOperator(double l, double r) {
        if(nodeValue == '+') {
            return r + l;
        } else if(nodeValue == '-') {
            return r - l;
        } else if(nodeValue == '*') {
            return r * l;
        } else if(nodeValue == '/'){
            return r / l;
        }

        return 0.0;
    }
}
