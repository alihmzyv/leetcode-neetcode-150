package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVIDE = "/";

    //time - O(n), space - O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            if (token.equals(PLUS)
                    || token.equals(MINUS)
                    || token.equals(MULTIPLE)
                    || token.equals(DIVIDE)) {
                Integer operand2 = operands.pop();
                Integer operand1 = operands.pop();
                operands.push(calculate(operand1, operand2, token));
            } else {
                operands.push(Integer.valueOf(token));
            }
        }

        return operands.peek();
    }

    //time - O(n), space - O(n)
    public int evalRPNRecursive(String[] tokens) {
        return evalRpnRecursive(tokens, new int[]{tokens.length - 1});
    }

    private int evalRpnRecursive(String[] tokensLeft, int[] index) {
        String lastToken = tokensLeft[index[0]];

        if (lastToken.equals(PLUS) ||
                lastToken.equals(MINUS) ||
                lastToken.equals(MULTIPLE) ||
                lastToken.equals(DIVIDE)) {
            index[0]--;
            int right = evalRpnRecursive(tokensLeft, index);
            index[0]--;
            int left = evalRpnRecursive(tokensLeft, index);

            return calculate(left, right, lastToken);
        } else {
            return Integer.parseInt(lastToken);
        }
    }

    private int calculate(int operand1, int operand2, String operator) {
        switch (operator) {
            case PLUS -> {
                return operand1 + operand2;
            }
            case MINUS -> {
                return operand1 - operand2;
            }
            case MULTIPLE -> {
                return operand1 * operand2;
            }
            case DIVIDE -> {
                return operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }
    }
}
