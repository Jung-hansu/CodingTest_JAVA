import java.io.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			int N = s[0].length(), M = s[1].length();
			int[][] dp = new int[N + 1][M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					
					if (s[0].charAt(i - 1) == s[1].charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
					
				}
			}
			sb.append('#').append(tc).append(' ').append(dp[N][M]).append('\n');
		}
		System.out.println(sb);
	}
	
}