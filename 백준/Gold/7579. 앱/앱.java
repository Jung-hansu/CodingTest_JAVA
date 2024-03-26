import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000_000;
    private static int[] active, cost;
    private static int N, M;

    private static int getMinCost(){
        int[][] dp = new int[2][M + 1];

        Arrays.fill(dp[0], INF);
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                if (j <= active[i])
                    dp[i&1][j] = Math.min(dp[i&1^1][j], cost[i]);
                else
                    dp[i&1][j] = Math.min(dp[i&1^1][j], dp[i&1^1][j - active[i]] + cost[i]);
            }
        }
        return dp[N&1][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        active = new int[N + 1];
        cost = new int[N + 1];

        //parse active
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            active[i] = Integer.parseInt(st.nextToken());
        }

        //parse cost
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMinCost());
    }

}