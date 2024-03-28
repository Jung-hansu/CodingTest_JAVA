import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int INF = 1_000_000_000;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] split = br.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int[][] adj = new int[N][N];
			
			//generate adjacency matrix
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i][j] = Integer.parseInt(split[i * N + j + 1]);
					if (adj[i][j] == 0) {
						adj[i][j] = INF;
					}
				}
			}
			
			//floyd-warshall
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i != j) {
							adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
						}
					}
				}
			}
			
			int minCC = INF;
			for (int i = 0; i < N; i++) {
				int cc = 0;
				
				for (int j = 0; j < N ;j++) {
					if (i != j) {
						cc += adj[i][j];
					}
				}
				minCC = Math.min(minCC, cc);
			}
			
			sb.append('#').append(tc).append(' ').append(minCC).append('\n');
		}
		System.out.print(sb);
	}

}