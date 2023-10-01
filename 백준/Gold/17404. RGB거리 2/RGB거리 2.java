import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), min = Integer.MAX_VALUE;
        int[][] rgb = new int[N][3];
        long[][][] dp = new long[3][N][3];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                rgb[i][j] = Integer.parseInt(st.nextToken());}

        for (int i = 0; i < 3; i++){
            Arrays.fill(dp[i][0], Integer.MAX_VALUE);
            dp[i][0][i] = rgb[0][i];

            for (int j = 1; j < N; j++) {
                dp[i][j][0] = rgb[j][0] + Math.min(dp[i][j-1][1], dp[i][j-1][2]);
                dp[i][j][1] = rgb[j][1] + Math.min(dp[i][j-1][0], dp[i][j-1][2]);
                dp[i][j][2] = rgb[j][2] + Math.min(dp[i][j-1][0], dp[i][j-1][1]);
            }
            dp[i][N-1][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                min = (int)Math.min(min, dp[i][N-1][j]);
        System.out.println(min);
    }
}
