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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        System.out.println(combine(N, K));
    }
}