import java.util.Scanner;

public class Main {
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long t = sc.nextLong();

            if (t == 0) {
                System.out.println("YES");
            } else if (t > Math.max(a, b)) {
                System.out.println("NO");
            } else if (t % gcd(a, b) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
