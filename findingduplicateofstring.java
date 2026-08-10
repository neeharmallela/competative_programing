import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        String str = sc.next();
        int seen = 0;
        int printed = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int mask = 1 << (ch - 'a');

            if ((seen & mask) != 0) {
                if ((printed & mask) == 0) {
                    result.append(ch).append(" ");
                    printed |= mask;
                }
            } else {
                seen |= mask;
            }
        }

        if (result.length() == 0) {
            System.out.println("No duplicates");
        } else {
            System.out.println(result.toString().trim());
        }
    }
}
