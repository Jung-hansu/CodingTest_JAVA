import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        Set<Integer> coins = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            coins.add(tmp);
            if (tmp <= K) dp[tmp] = 1;
        }
        for (int coin : coins)
            for (int i = coin+1; i <= K; i++)
                if (dp[i-coin] > 0)
                    dp[i] = dp[i] > 0 ? Math.min(dp[i], dp[i - coin] + 1) : dp[i - coin] > 0 ? dp[i - coin] + 1 : 0;
        System.out.println(dp[K]>0?dp[K]:-1);
    }
}
