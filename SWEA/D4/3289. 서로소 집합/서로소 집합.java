import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[] parent;
	
	private static void union(int a, int b) {
		int x = find(a), y = find(b);
		parent[Math.max(x, y)] = Math.min(x, y);
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			//init parent
			parent = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				parent[i] = i;
			}
			
			//run
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if (op == 0) {
					union(A, B);
				}
				else {
					sb.append(find(A) == find(B) ? '1' : '0');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}