import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine().trim());
        long[] arr = new long[n];
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tokenizer.nextToken());
        }
        
        long x = Long.parseLong(reader.readLine().trim());
        
        Arrays.sort(arr);
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                
                if (sum == x) {
                    results.add(arr[i] + " " + arr[left] + " " + arr[right]);
                    
                    left++;
                    right--;
                    
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("No Triplet Found");
        } else {
            for (String triplet : results) {
                System.out.println(triplet);
            }
        }
    }
}
