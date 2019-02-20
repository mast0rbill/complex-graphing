package com.example.math;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class FunctionParser {
    public FunctionParser() {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        ExpressionNode n = ParseFunction(s);
        PrintExpressionNode(n, 0);
        System.out.println("Answer: " + EvaluateExpressionTree(n));

        scan.close();
    }

    private ExpressionNode ParseFunction(String f) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < f.length(); i++) {
            char c = f.charAt(i);

            if(ExpressionNode.IsOperator(c)) {
                operatorStack.push(c);
            } else {
                String val = "";
                int j = i;
                while(j < f.length() && !ExpressionNode.IsOperator(f.charAt(j))) {
                    val += f.charAt(j);
                    j++;
                }
                j = j - i;
                i += j - 1;

                operandStack.push(Double.valueOf(val));
            }
        }

        ExpressionNode returned = GenerateNode(operandStack, operatorStack);
        return returned;
    }

    private ExpressionNode GenerateNode(Stack<Double> opd, Stack<Character> opt) {
        ExpressionNode returned = new ExpressionNode();
        returned.nodeValue = opt.pop();
        returned.nodeType = ExpressionNode.NodeType.Operator;

        ExpressionNode r, l;

        if(opt.isEmpty()) {
            l = new ExpressionNode();
            l.nodeType = ExpressionNode.NodeType.Number;
            l.numericalValue = opd.pop();

            r = new ExpressionNode();
            r.nodeType = ExpressionNode.NodeType.Number;
            r.numericalValue = opd.pop();
        } else {
            l = new ExpressionNode();
            l.nodeType = ExpressionNode.NodeType.Number;
            l.numericalValue = opd.pop();

            r = GenerateNode(opd, opt);
        }

        returned.left = l;
        returned.right = r;

        return returned;
    }

    private double EvaluateExpressionTree(ExpressionNode n) {
        if(n.nodeType == ExpressionNode.NodeType.Number) {
            return n.numericalValue;
        }

        return n.ApplyOperator(EvaluateExpressionTree(n.left), EvaluateExpressionTree(n.right));
    }

    private void PrintExpressionNode(ExpressionNode n, int spaces) {
        if(n == null) {
            return;
        }

        for(int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        if(n.nodeType == ExpressionNode.NodeType.Operator)
            System.out.print(n.nodeValue + " \n");
        else
            System.out.print(n.numericalValue + " \n");

        for(int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print("Left: \n");
        PrintExpressionNode(n.left, spaces + 1);

        for(int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print("Right: \n");
        PrintExpressionNode(n.right, spaces + 1);
    }


    public static void main(String[] args){
        new FunctionParser();
    }

}
