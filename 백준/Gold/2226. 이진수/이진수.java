import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N+2];
        
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++)
            dp[i] = dp[i-2].multiply(BigInteger.TWO).add(dp[i-1]);
        System.out.println(dp[N-1]);
    }
}
