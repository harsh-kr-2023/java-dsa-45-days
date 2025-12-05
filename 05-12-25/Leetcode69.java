public class Leetcode69 {
    public static void main(String[] args) {
        int x = 116;
        System.out.println(mySqrt(x));
    }

    static int mySqrt(int x) {
        return sqrtHelper(x, x);  // x stays constant, guess starts as x
    }

    static int sqrtHelper(int x, int guess) {
        System.out.println("Current guess: " + guess);

        int nextGuess = (guess + x / guess) / 2;
        System.out.println("Next guess: " + nextGuess);

        // Stopping condition: when the guess stops changing
        if (nextGuess == guess) {
            return nextGuess;   // convergence reached
        }

        return sqrtHelper(x, nextGuess);
    }
}
