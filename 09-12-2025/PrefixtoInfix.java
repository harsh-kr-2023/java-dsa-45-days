
import java.util.Stack;

public class PrefixtoInfix {
    public static void main(String[] args) {
        String prefix = "*+PQ-MN";
        String infix = convertToInfix(prefix);
        System.out.println("Infix: " + infix);
    }
    static String convertToInfix(String prefix) {
        int i = prefix.length() - 1;
        String result = "";
        Stack<String> stack = new Stack<>();
        while (i >= 0) {
            char currentChar = prefix.charAt(i);
            if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')
                    || (currentChar >= '0' && prefix.charAt(i) <= '9')) {
                stack.push(String.valueOf(currentChar));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand1 + currentChar + operand2 + ")");
                result = stack.peek();
            }
            i--;
        }
        return result;
    }
}
