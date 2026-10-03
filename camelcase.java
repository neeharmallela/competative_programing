import java.util.*;

public class Main {
    static String getAbbr(String s) {
        String a = "";
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                a += c;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = sc.nextLine().split(",");
        String pattern = sc.nextLine();

        ArrayList<String> ans = new ArrayList<>();

        for (String s : words) {
            String abbr = getAbbr(s);

            if (abbr.startsWith(pattern))
                ans.add(s);
        }

        Collections.sort(ans);

        if (ans.isEmpty())
            System.out.println("No match found");
        else
            for (String s : ans)
                System.out.println(s);
    }
}
