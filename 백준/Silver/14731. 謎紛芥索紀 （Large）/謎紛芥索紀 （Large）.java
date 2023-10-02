import java.io.*;
import java.util.*;

public class Main {
    private static final int P = 1000000007;
    private static long pow(long x, long n){
        long res = 1;

        while(n > 0){
            long tmp = x;
            for (long i = Long.highestOneBit(n); i > 1; i >>= 1)
                tmp = tmp * tmp % P;
            n ^= Long.highestOneBit(n);
            res = res * tmp % P;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long res = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()), n = Long.parseLong(st.nextToken());
            res += ((x * n % P) * pow(2, n-1) % P) % P;
        }
        System.out.println(res % P);
    }
}
