public class IntToBinary {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(convertToBinary(n));
    }

    static String convertToBinary(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 1)
                res.append("1");
            else
                res.append("0");
            n /= 2;
            System.out.println(res);
        }
        return res.reverse().toString();
    }
}
