public class LeetCode2011 {
    public static void main(String[] args) {
        String[] operations = { "++X", "X++", "--X", "X--" };
        int result = finalValueAfterOperations(operations);
        System.out.println("Final value after operations: " + result); 
    }
    static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
