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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(eulerPhi(N));
    }

}