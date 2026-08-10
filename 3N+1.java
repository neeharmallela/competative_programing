import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Long, Integer> cache = new HashMap<>();

    public static int getCycleLength(long n) {
        if (n == 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        int length;
        if (n % 2 == 0) {
            length = 1 + getCycleLength(n / 2);
        } else {
            length = 1 + getCycleLength(3 * n + 1);
        }

        cache.put(n, length);
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            int start = Math.min(i, j);
            int end = Math.max(i, j);

            int maxLength = 0;
            for (int n = start; n <= end; n++) {
                maxLength = Math.max(maxLength, getCycleLength(n));
            }

            System.out.println(i + " " + j + " " + maxLength);
        }

        scanner.close();
    }
}
