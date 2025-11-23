public class FirstOccurence {
    public static void main(String[] args) {
        String hayStack = "sadnotsad";
        String needle = "not";
        int index = -1;

        OuterLoop:
        for (int i = 0; i < hayStack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if(hayStack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    index = i;
                    break OuterLoop;
                }
            }
        }
        System.out.println("First occurrence index: " + index);
    }
}
