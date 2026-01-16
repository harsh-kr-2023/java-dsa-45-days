import java.util.*;

public class LeetCode22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    public static List<String> generateParenthesis(int n) {
        // recursion and backtracking approach
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    public static void backtrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }
}
