import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];

        if (N == 1){
            System.out.println(1);
            return;
        }
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i < N; i++)
            dp[i][0] = ((dp[i][1] = dp[i - 1][0]) + dp[i - 1][1]) % 10007;
        System.out.println((dp[N-1][0] + dp[N-1][1]) % 10007);
    }
}
