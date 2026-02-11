import java.util.Stack;

public class PrefixtoPostfix {
    public static void main(String[] args) {
        String prefix = "/-AB*+DEF";
        String postfix = convertToPostfix(prefix);
        System.out.println("Postfix: " + postfix);
    }

    static String convertToPostfix(String prefix) {
        int i = prefix.length() - 1;
        String result = "";
        Stack<String> stack = new Stack<>();
        while (i >= 0) {
            char currentChar = prefix.charAt(i);
            if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z') || (currentChar >= '0' && prefix.charAt(i) <= '9')) {
                stack.push(String.valueOf(currentChar));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(operand1 + operand2 + currentChar);
                result = stack.peek();
            }
            i--;
        }
        return result;
    }
}
