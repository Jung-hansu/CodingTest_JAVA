import java.io.*;

public class Main {
    
    private static int readInt() throws IOException {
        int c, n = 0;
        
        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++){
            int term = readInt();
            int cost = readInt();

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + term <= N + 1){
                dp[i + term] = Math.max(dp[i + term], dp[i] + cost);
            }
        }
        System.out.println(dp[N + 1]);
    }

}