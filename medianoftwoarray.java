import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        int totalLength = n + m;
        int mid1Idx = totalLength / 2;
        int mid2Idx = mid1Idx - 1;
        
        int val1 = 0, val2 = 0;
        int i = 0, j = 0, k = 0;
        
        while (i < n || j < m) {
            int current;
            if (i < n && (j >= m || arr1[i] <= arr2[j])) {
                current = arr1[i++];
            } else {
                current = arr2[j++];
            }
            
            if (k == mid2Idx) {
                val2 = current;
            }
            if (k == mid1Idx) {
                val1 = current;
                break;
            }
            k++;
        }
        
        if (totalLength % 2 != 0) {
            System.out.println(val1);
        } else {
            double median = (val1 + val2) / 2.0;
            System.out.printf("%.1f\n", median);
        }
    }
}

