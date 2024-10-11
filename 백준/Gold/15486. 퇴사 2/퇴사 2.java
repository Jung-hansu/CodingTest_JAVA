import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N + 2][2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N + 1; i++){
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + schedules[i][0] <= N + 1){
                dp[i + schedules[i][0]] = Math.max(dp[i + schedules[i][0]], dp[i] + schedules[i][1]);
            }
        }
        System.out.println(dp[N + 1]);
    }

}