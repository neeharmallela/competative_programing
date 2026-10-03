import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[V + 1];
        Arrays.fill(dp, V + 1);
        dp[0] = 0;

        for (int amount = 1; amount <= V; amount++) {
            for (int coin : coins) {
                if (coin <= amount) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }

        System.out.println(dp[V] > V ? -1 : dp[V]);
    }
}
