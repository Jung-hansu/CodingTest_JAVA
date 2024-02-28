import java.io.*;
import java.util.*;

public class Main {
    private static final int P = 1000000007;
    private static long pow (long base, long exp){
        if (exp == 1) return base % P;
        long tmp = pow(base, exp/2);

        return exp%2 == 0 ? tmp * tmp % P : tmp * tmp % P * base % P;
    }
    private static int combine(int n, int k){
        long tmp1 = 1, tmp2 = 1;
        for (int i = 0; i < k; i++) tmp1 = tmp1 * (n-i) % P;
        for (int i = 2; i <= k; i++) tmp2 = tmp2 * i % P;
        return (int)(tmp1 * pow(tmp2, P-2) % P);
    }
    private static int readInt() throws IOException {
        int c, n = 0;
        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws IOException{
        int N = readInt(), K = readInt();

        System.out.println(combine(N, Math.min(K, N-K)));
    }
}