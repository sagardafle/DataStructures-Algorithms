/**
 * Source: https://www.youtube.com/watch?v=vq-nUF0G4fI
 */
import java.util.*;
class InfixToPostfix {
    static String exp;
    public static void main(String[] args) {
        InfixToPostfix intopost = new InfixToPostfix();
        exp = "((A+B)*C-D)*E";
        //exp = "A+B*C";
        String postfixstr = intopost.convertToPostfix(exp);
        System.out.println("Original String " + exp);
        System.out.println("Converted String " + postfixstr);
    }

    /**
     * LOGIC: 
     * 1. Create an empty stack 's' and output postfix string 'postfixstr'
     * 2. Parse the input infix string. 
     *    2.1 If it is operand, append the operand to postfixstr.
     *    2.2 Else if it is operator: 
     *       2.2.1 Keep popping the stack while: 1. Stack is not empty 2. s.peek() has higher precedence over the current operator 3. s.peek is not opening bracket.
     *       2.2.2 If all 3 conditions above are true, Append the operator from stack top to the output string.
     *       2.2.2 Else, we just push the current operator in input string to stack.
     *      
     */
    public String convertToPostfix(String originalstring) {
        Stack < Character > s = new Stack<>();
        String postfix = "";
        char[] expression = originalstring.toCharArray();
        for (int i = 0; i < expression.length; i++) {

            if (expression[i] == ' ' || expression[i] == ',') continue;

            else if (isOperator(expression[i])) {
                while (!s.empty() && s.peek() != '(' && hasHigherPrecedence(s.peek(), expression[i])) {
                    postfix += s.peek();
                    s.pop();
                }
                s.push(expression[i]);
            } else if (isOperand(expression[i])) {
                postfix += expression[i];
            } else if (expression[i] == '(') {
                s.push(expression[i]);
            } else if (expression[i] == ')') {
                while (!s.empty() && s.peek() != '(') {
                    postfix += s.peek();
                    s.pop();
                }
                s.pop();
            }
        }

        while (!s.empty()) {
            postfix += s.peek();
            s.pop();
        }

        return postfix;
    }

    boolean isOperator(char C) {
        if (C == '+' || C == '-' || C == '*' || C == '/' || C == '$' || C == '^')
            return true;

        return false;
    }

    boolean isOperand(char C) {
        if (C >= '0' && C <= '9') return true;
        if (C >= 'a' && C <= 'z') return true;
        if (C >= 'A' && C <= 'Z') return true;
        return false;
    }

    // Function to perform an operation and return output. 
    boolean hasHigherPrecedence(char op1, char op2) {
        int op1Weight = GetOperatorWeight(op1);
        int op2Weight = GetOperatorWeight(op2);

        // If operators have equal precedence, return true if they are left associative. 
        // return false, if right associative. 
        // if operator is left-associative, left one should be given priority. 
        if (op1Weight == op2Weight) {
            if (IsRightAssociative(op1)) return false;
            else return true;
        }
        return op1Weight > op2Weight ? true : false;
    }

    int GetOperatorWeight(char op) {
        int weight = -1;
        switch (op) {
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
            case '^':
                weight = 3;
                break;
        }
        return weight;
    }

    boolean IsRightAssociative(char op) {
        if (op == '$') return true;
        return false;
    }
}