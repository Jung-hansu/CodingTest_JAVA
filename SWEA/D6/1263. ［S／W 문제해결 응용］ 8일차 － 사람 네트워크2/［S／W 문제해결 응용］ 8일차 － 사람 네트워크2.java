import java.io.*;
import java.util.*;

public class Solution {
	
	private static final int INF = 1_000_000_000;
	
	private static int floyd(int[][] adj, int N) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k) continue;
				for (int j = 0; j < N; j++) {
					if (i != j && j != k) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
		}
		
		int minCC = INF;
		for (int[] row : adj) {
			int cc = 0;
			
			for (int n : row) {
				if (n < INF) {
					cc += n;
				}
			}
			minCC = Math.min(minCC, cc);
		}
		
		return minCC;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adj = new int[N][N];
			
			//generate adjacency matrix
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i][j] = st.nextToken().equals("1") ? 1 : INF;
					if (i == j) {
						adj[i][j] = 0;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(floyd(adj, N)).append('\n');
		}
		System.out.print(sb);
	}

}
