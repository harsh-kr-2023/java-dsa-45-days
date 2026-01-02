public class LeetCode443 {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int res = compress(chars);
        System.out.println(res);
    }

    static int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        int n = chars.length;
        while (fast < n) {
            char currentChar = chars[fast];
            int count = 0;
            while (fast < n && chars[fast] == currentChar) {
                fast++;
                count++;
            }
            chars[slow] = currentChar;
            slow++;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[slow] = c;
                    slow++;
                }
            }
        }
        return slow;
    }
}
