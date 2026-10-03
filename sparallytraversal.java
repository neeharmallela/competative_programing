import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] a = new long[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        StringBuilder ans = new StringBuilder();

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                ans.append(a[top][j]).append(" ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.append(a[i][right]).append(" ");
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.append(a[bottom][j]).append(" ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.append(a[i][left]).append(" ");
                }
                left++;
            }
        }

        System.out.println(ans.toString().trim());
    }
}
