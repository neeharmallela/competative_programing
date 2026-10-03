import java.util.Scanner;

public class Main {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private static TrieNode root;

    private static void insert(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    private static boolean search(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        String keysInput = sc.next();
        String searchKey = sc.next();
        
        root = new TrieNode();
        
        String[] keys = keysInput.split(",");
        for (String key : keys) {
            insert(key);
        }
        
        if (search(searchKey)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        sc.close();
    }
}
