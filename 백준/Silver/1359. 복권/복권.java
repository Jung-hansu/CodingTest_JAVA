import java.io.*;
import java.util.*;

public class Main {
    private static int mCk(int M, int K){
        if (M == K || K == 0) return 1;
        return mCk(M-1, K) + mCk(M-1, K-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double N = Double.parseDouble(st.nextToken()),
               M = Double.parseDouble(st.nextToken()),
               K = Double.parseDouble(st.nextToken()),
               answer = 0;

        while (K-- > 0){
            double mOfn = 1, i, j;
            for (i = 0; i < K; i++) mOfn *= (M-i)/(N-i);
            for (j = 0; j < M-K; j++) mOfn *= (N-M-j)/(N-i-j);
            answer += mOfn * mCk((int)M, (int)K);
        }
        System.out.println(1-answer);
    }
}