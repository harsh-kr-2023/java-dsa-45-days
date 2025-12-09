public class S1L58 {
    public static void main(String[] args) {
        String str = "madam";

        System.out.println(isPalindromeByReversing(str));
        System.out.println(isPalindromeTwoPointer(str));
        System.out.println(isPalindromeRec(str, 0, str.length() - 1));
    }

    // 1st approach: create reversed string and compare
    static boolean isPalindromeByReversing(String str) {
        StringBuilder rev = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }

        return str.equals(rev.toString());
    }

    // 2nd approach: two-pointer method
    static boolean isPalindromeTwoPointer(String str) {
        int low = 0, high = str.length() - 1;

        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    // 3rd approach: recursion
    static boolean isPalindromeRec(String str, int low, int high) {
        if (low >= high) return true;
        if (str.charAt(low) != str.charAt(high)) return false;

        return isPalindromeRec(str, low + 1, high - 1);
    }
}
