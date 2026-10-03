import java.io.*;
import java.util.*;

public class Main {
    public static long getWays(int n, int[] c) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin : c) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] c = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getWays(n, c));
    }
}
