import java.io.*;

public class Main {

    private static long eulerPhi(long N){
        long res = N;

        for (int p = 2; (long)p * p <= N; p++){
            if (N % p == 0){
                res = res / p * (p - 1);
                while (N % p == 0){
                    N /= p;
                }
            }
        }
        if (N > 1){
            res = res / N * (N - 1);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int c;
        long N = 0;

        while((c = System.in.read()) > 32){
            N = (N << 3) + (N << 1) + (c & 15);
        }
        System.out.println(eulerPhi(N));
    }

}