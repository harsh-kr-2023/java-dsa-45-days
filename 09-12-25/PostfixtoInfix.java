import java.util.Stack;

public class PostfixtoInfix {
    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        String infix = convertToInfix(postfix);
        System.out.println("Infix: " + infix);
    }

    static String convertToInfix(String postfix) {
        int i = 0;
        int n = postfix.length();
        String result = "";
        Stack<String> stack = new Stack<>();
        while (i < n) {
            char currentChar = postfix.charAt(i);
            if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')
                    || (currentChar >= '0' && postfix.charAt(i) <= '9')) {
                stack.push(String.valueOf(currentChar));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand2 + currentChar + operand1 + ")");
                result = stack.peek();
            }
            i++;
        }
        return result;
    }
}
