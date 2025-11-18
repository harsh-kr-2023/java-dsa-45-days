    import java.util.Scanner;

    public class Pattern11 {
        public static void main(String[] args) {
            System.out.println("Enter Size : ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int flag = (i % 2 == 0) ? 1 : 0;
                for (int j = 0; j <= i; j++) {
                    System.out.print(flag + " ");
                    flag = 1 - flag;  // Instead of if-else
                }
                System.out.println();
            }
        }
    }
