import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        long[][] dp = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < cols; j++) {
                long value = Long.parseLong(st.nextToken());

                if (i == 0 && j == 0) {
                    dp[i][j] = value;
                } else {
                    long min = Long.MAX_VALUE;

                    if (i > 0) {
                        min = Math.min(min, dp[i - 1][j]);
                    }

                    if (j > 0) {
                        min = Math.min(min, dp[i][j - 1]);
                    }

                    if (i > 0 && j > 0) {
                        min = Math.min(min, dp[i - 1][j - 1]);
                    }

                    dp[i][j] = value + min;
                }
            }
        }

        System.out.println(dp[rows - 1][cols - 1]);
    }
}
