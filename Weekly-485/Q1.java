public class Q1 {
    public static void main(String[] args) {
        String s = "cooear";
        System.out.println(vowelConsonantScore(s));
    }

    public static int vowelConsonantScore(String s) {
        int v_score = 0;
        int c_score = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                v_score += 1;
            } 
            // if consonant not num
            else if (Character.isLetter(c)) {
                c_score += 1;
            }
        }
        if(c_score > 0) return (int) Math.floor(v_score / c_score);
        else return 0;
    }
}
