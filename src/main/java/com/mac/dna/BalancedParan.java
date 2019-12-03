package com.mac.DnA;

public class BalancedParan {
    public static void main(String[] args) {
        System.out.println(areParenthesisBalanced("(())"));
        System.out.println(areParenthesisBalanced("(())()"));
        System.out.println(areParenthesisBalanced("((()))))("));
    }

    private static boolean areParenthesisBalanced(String s) {
        char[] panthers = s.toCharArray();
        Stack stack = new Stack();
        for (char c:panthers){
            if(c=='{' || c == '(' || c == '['){
                stack.push(c);
            }
            if (c == '}' || c == ')' || c == ']'){
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) return false;
            }
        }
        return stack.isEmpty();
    }

    static boolean isMatchingPair(char character1, char character2) {
        return character1 == '(' && character2 == ')' || character1 == '{' && character2 == '}' || character1 == '[' && character2 == ']';
    }

    static class Stack {
        int top = -1;
        char[] items = new char[100];

        void push(char x) {
            if (top == 99) System.out.println("Stack Full");
            else items[++top] = x;
        }

        char pop() {
            if (top == -1) {
                System.out.println("Underflow error");
                return '\0';
            } else {
                char element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty() {
            return top == -1;
        }
    }
}
