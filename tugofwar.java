import java.util.*;

public class Main {
    static int n, ans = Integer.MAX_VALUE;
    static int[] a;

    static void solve(int i, int count, int sum, int total) {
        if (i == n) {
            int c2 = n - count;

            if (Math.abs(count - c2) <= 1)
                ans = Math.min(ans, Math.abs(sum - (total - sum)));

            return;
        }

        solve(i + 1, count + 1, sum + a[i], total);
        solve(i + 1, count, sum, total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n];

        int total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            total += a[i];
        }

        solve(0, 0, 0, total);

        System.out.println(ans);
    }
}
