import java.util.Stack;

public class PostfixtoPrefix {
    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        String prefix = convertToPrefix(postfix);
        System.out.println("Prefix: " + prefix);
    }

    static String convertToPrefix(String postfix) {
        int i = 0;
        int n = postfix.length();
        String result = "";
        Stack<String> stack = new Stack<>();
        while(i<n){
            char currentChar = postfix.charAt(i);

            if(currentChar >= 'A' && currentChar <= 'Z' || currentChar >= 'a' && currentChar <= 'z' || currentChar >= '0' && currentChar <= '9') {
                stack.push(String.valueOf(currentChar));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(currentChar + operand2 + operand1);
                result = stack.peek();
            }
            i++;
        }
        return result;
    }
}
