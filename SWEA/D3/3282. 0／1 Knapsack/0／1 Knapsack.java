import java.io.*;

public class Solution {
    
    private static int readInt() throws IOException{
        int c, n = 0;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static int knapsack(int[] volumes, int[] values, int N, int K){
        int[][] dp = new int[N + 1][K + 1];

        for (int n = 1; n <= N; n++){
            for (int k = 1; k <= K; k++){
                if (k >= volumes[n]){
                    dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - volumes[n]] + values[n]);
                }
                else{
                    dp[n][k] = dp[n - 1][k];
                }
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = readInt(), K = readInt();
            int[] volumes = new int[N + 1], values = new int[N + 1];

            for (int i = 1; i <= N; i++){
                volumes[i] = readInt();
                values[i] = readInt();
            }

            sb.append('#').append(tc).append(' ').append(knapsack(volumes, values, N, K)).append('\n');
        }
        System.out.println(sb);
    }

}