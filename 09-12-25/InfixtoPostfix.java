
import java.util.Stack;

class InfixtoPostfix {
    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        String postfix = convertToPostfix(infix);
        System.out.println("Postfix: " + postfix);
    }

    static String convertToPostfix(String infix) {
        // Implementation will go here
        int i = 0;
        int n = infix.length();
        Stack<Character> stack = new Stack<>();
        String ans = "";
        while (i < n) {
            if ((infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z') || (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z')
                    || (infix.charAt(i) >= '0' && infix.charAt(i) <= '9')) {
                ans += infix.charAt(i);
            } else if(infix.charAt(i) == '(') {
                stack.push(infix.charAt(i));
            } else if(infix.charAt(i) == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(infix.charAt(i))) {
                    ans += stack.pop();
                }
                stack.push(infix.charAt(i));
            }
            i++;
        }
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
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
}