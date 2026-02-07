// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - 
//
// INPUT:
// - 
//
// OUTPUT:
// - 
//
// ASSUMPTIONS:
// - 
//
// -------------------------------------
// BRUTE FORCE:
// - Idea:
// - Time:
// - Space:
// - Why not optimal?
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique:
// - Idea:
// - Why it works:
// - Invariant: After processing the first i elements, <state> correctly represents <meaning for processed portion>.
//
// -------------------------------------
// EDGE CASES:
// - Boundary condition where input size or value is at its minimum or maximum
// - Case where assumptions are barely satisfied (e.g., smallest valid input)
// - Case that could break logic if not handled explicitly
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time:
// - Space:
//
// -------------------------------------
// FAILURE MODES:
// - This approach assumes <key assumption>.
// - It fails or becomes invalid if <assumption is violated>.
// =====================================
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] res = plusOne(digits);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
