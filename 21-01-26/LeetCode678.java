import java.util.Stack;

public class LeetCode678 {
    public static void main(String[] args) {
        String s = "()(*";
        System.out.println(checkValidString1(s));
    }

    public static boolean checkValidString(String s) {
        // 2 Stacks Approach
        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> openStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.pop() > starStack.pop()) {
                return false;
            }
        }
        return openStack.isEmpty();
    }

    public static boolean checkValidString1(String s) {
        // Greedy Approach
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }
            if (high < 0) {
                return false;
            }
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}