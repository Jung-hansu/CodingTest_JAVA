import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int term = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + term <= N + 1){
                dp[i + term] = Math.max(dp[i + term], dp[i] + cost);
            }
        }
        System.out.println(dp[N + 1]);
    }

}