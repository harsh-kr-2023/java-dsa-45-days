public class Leetcode761 {
    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000")); // 11100100
    }

    public static String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s; // "10" is the smallest special string

        List<String> list = new ArrayList<>();
        int count = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) { // found a special string
                String inner = makeLargestSpecial(s.substring(start + 1, i)); // recursively sort the inner part
                list.add("1" + inner + "0"); // add the outer part
                start = i + 1; // move to the next part
            }
        }

        Collections.sort(list, Collections.reverseOrder()); // sort in descending order
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
