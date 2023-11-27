import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[4] = dp[5] = (dp[1] = dp[2] = dp[3] = 1) + 1;
        for (int i = 6; i <= 100; i++) dp[i] = dp[i-1] + dp[i-5];
        for (int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N]+"\n");
        }
        bw.close();
    }
}
