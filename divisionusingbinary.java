import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dividend = Long.parseLong(br.readLine().trim());
        long divisor = Long.parseLong(br.readLine().trim());
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            System.out.println(Integer.MAX_VALUE);
            return;
        }
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        
        long absDividend = Math.abs(dividend);
        long absDivisor = Math.abs(divisor);
        
        int quotient = 0;
        
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;
            
            while (absDividend >= (tempDivisor << 1)) {
                if ((tempDivisor << 1) <= 0) {
                    break;
                }
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            absDividend -= tempDivisor;
            quotient += multiple;
        }
        
        System.out.println(sign * quotient);
    }
}

