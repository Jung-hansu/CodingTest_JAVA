import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N + 1][K + 1];

            for (int n = 1; n <= N; n++){
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                for (int k = 1; k <= K; k++){
                    if (k < V){
                        dp[n][k] = dp[n - 1][k];
                    }
                    else{
                        dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - V] + C);
                    }
                }
            }
            sb.append('#').append(tc).append(' ').append(dp[N][K]).append('\n');
        }
        System.out.println(sb);
    }

}