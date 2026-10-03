import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        long[] result = extendedGcd(a, b);
        long x0 = result[0];
        long y0 = result[1];
        long d = result[2];
        
        long stepX = b / d;
        long stepY = a / d;
        
        long kCenter = -x0 / stepX;
        
        long bestX = 0;
        long bestY = 0;
        long minCost = Long.MAX_VALUE;
        
        for (long k = kCenter - 2; k <= kCenter + 2; k++) {
            long cx = x0 + k * stepX;
            long cy = y0 - k * stepY;
            long cost = Math.abs(cx) + Math.abs(cy);
            
            if (cost < minCost) {
                minCost = cost;
                bestX = cx;
                bestY = cy;
            } else if (cost == minCost) {
                if (cx <= cy && (bestX > bestY || cx < bestX)) {
                    bestX = cx;
                    bestY = cy;
                }
            }
        }
        
        System.out.println(bestX + " " + bestY + " " + d);
    }
    
    private static long[] extendedGcd(long a, long b) {
        if (b == 0) {
            return new long[]{1, 0, a};
        }
        long[] next = extendedGcd(b, a % b);
        long x1 = next[0];
        long y1 = next[1];
        long d = next[2];
        return new long[]{y1, x1 - (a / b) * y1, d};
    }
}
