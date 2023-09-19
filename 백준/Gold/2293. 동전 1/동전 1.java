import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N], dp = new int[10001];

        dp[0] = 1;
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
        for (int coin : coins)
            for (int i = coin; i <= K; i++)
                dp[i] += dp[i-coin];
        System.out.println(dp[K]);
    }
}
