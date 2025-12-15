public class Problem2 {
    public static void main(String[] args) {
        String s = "book is nice";
        System.out.println(reverseWords(s));

        String s2 = "cat and mice";
        System.out.println(reverseWords(s2));

        String s3 = "banana healthy";
        System.out.println(reverseWords(s3));
    }

    static String reverseWords(String s) {
        if(s == null || s.trim().isEmpty()) {
            return "";
        }

        // Split string into array of words
        String[] words = s.split("\\s+");

        if(words.length == 0) {
            return "";
        }

        String firstWord = words[0];
        int targetVowelCount = countVowels(firstWord);
        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            int currentVowelCount = countVowels(currentWord);

            if(currentVowelCount == targetVowelCount) {
                words[i] = reverseWord(currentWord);
            }
        }
        return String.join(" ", words);
    }

    static int countVowels(String word) {
        int count = 0;
        String vowels = "aeiou";
        for (char c : word.toCharArray()) {
            if(vowels.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }

    static String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
