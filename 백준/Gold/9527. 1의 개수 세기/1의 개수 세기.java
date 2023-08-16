import java.io.*;
import java.util.*;

public class Main {
    private static long getDigit(long n){
        long digit = 0;
        while ((n>>(digit+1)) > 0) digit++;
        return digit;
    }
    private static long getPrevOnes(long n){
        long res = Long.bitCount(n);
        for (long i = 0; n > 0; i++){
            long digit = getDigit(n);
            res += i*(1L <<digit) + digit*(1L<<(digit-1));
            n -= 1L<<digit;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());

        System.out.println(getPrevOnes(B) - getPrevOnes(A-1));
    }
}
