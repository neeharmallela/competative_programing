import java.util.Scanner;

public class Solution {

    private static final int[] ROW_DIR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_DIR = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void dfs(char[][] grid, int r, int c, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        for (int d = 0; d < 8; d++) {
            dfs(grid, r + ROW_DIR[d], c + COL_DIR[d], n, m);
        }
    }
}
