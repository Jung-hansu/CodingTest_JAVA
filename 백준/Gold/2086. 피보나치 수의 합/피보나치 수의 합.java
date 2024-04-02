import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int M = 1_000_000_000;

    //arr => {A(2n-1), A(2n)}
    private static void getDoubleFibo(long[] arr) {
        long tmp1 = arr[0], tmp2 = arr[1];

        arr[0] = (tmp1 * tmp1 % M + tmp2 * tmp2 % M) % M;
        arr[1] = (2 * tmp1 * tmp2 % M + tmp2 * tmp2 % M) % M;
    }

    //arr => {A(n), A(n+1)}
    private static void getNextFibo(long[] arr) {
        long tmp1 = arr[0], tmp2 = arr[1];

        arr[0] = tmp2;
        arr[1] = (tmp1 + tmp2) % M;
    }

    private static long getFibo(long N){
        long[] arr = {0, 1}; //{A(n-1), A(n)}

        if (N <= 1){
            return N;
        }

        for (long b = Long.highestOneBit(N) >> 1; b > 0; b >>= 1) {
            getDoubleFibo(arr);
            if ((N & b) > 0) {
                getNextFibo(arr);
            }
        }
        return arr[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());

        System.out.println((getFibo(B + 2) - getFibo(A + 1) + M) % M);
    }

}