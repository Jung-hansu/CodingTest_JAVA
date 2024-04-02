import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		int T = Integer.parseInt(br.readLine());
		
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		
		System.out.print(sb);
	}
	
}