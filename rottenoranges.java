import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            System.out.println(0);
            return;
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int time = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m
                            && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            if (rotted) {
                time++;
            }
        }

        System.out.println(fresh == 0 ? time : -1);
    }
}
