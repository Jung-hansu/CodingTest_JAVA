import java.io.*;
import java.util.*;

public class Main {
	
	//파스칼 삼각형 - 1차원 배열 구현
	private static int nCr(int n, int r) {
		int[] dp = new int[r + 1];
		
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int cur = 1, prev = cur;
			
			for (int j = 1; j <= Math.min(i, r); j++) {
				prev = cur;
				cur = dp[j];
				dp[j] += prev;
			}
		}
		return dp[r];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(nCr(M, N)).append('\n');
		}
		System.out.print(sb);
	}
	
}