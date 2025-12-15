public class Leetcode58 {
    public static void main(String[] args) {
        String s = "  Hello  World  ";
        System.out.println(lengthOfLastWord(s));
    }
    static int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        int arrayLength = words.length;
        return words[arrayLength-1].length();
    }
}
