import java.util.Stack;

public class InfixtoPrefix {
    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        String prefix = convertToPrefix(infix);
        System.out.println("Prefix: " + prefix);
    }

    static String convertToPrefix(String infix) {
        String reversedInfix = reverseString(infix);
        // System.out.println(reversedInfix);
        int i = 0;
        int n = reversedInfix.length();
        String result = "";
        Stack<Character> stack = new Stack<>();
        while (i < n) {
            char currentChar = reversedInfix.charAt(i);
            if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')
                    || (currentChar >= '0' && currentChar <= '9')) {
                result += currentChar;
            } else if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                if (currentChar == '^') {
                    while (!stack.isEmpty() && precedence(currentChar) <= precedence(stack.peek())) {
                        result += stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && precedence(currentChar) < precedence(stack.peek())) {
                        result += stack.pop();
                    }
                }
                stack.push(currentChar);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return reverseString(result);
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return -1;
    }

    static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                reversed += ')';
            } else if (str.charAt(i) == ')') {
                reversed += '(';
            } else {
                reversed += str.charAt(i);
            }
        }
        return reversed;
    }
}
