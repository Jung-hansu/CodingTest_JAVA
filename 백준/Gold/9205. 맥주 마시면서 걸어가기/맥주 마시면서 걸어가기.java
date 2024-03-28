import java.io.*;
import java.util.*;

public class Main {
	
	private static boolean canGo(int[] p1, int[] p2) {
		int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
		return dist <= 1000;
	}

	private static boolean bfs(List<Integer>[] adj, int N) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 2];
		
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.remove();
			
			if (adj[cur].contains(N + 1)) {
				return true;
			}
			
			for (int v : adj[cur]) {
				if (!visited[v]) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] coords = new int[N + 2][];
			List<Integer>[] adj = new List[N + 2];
			
			//parse coordinates
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				coords[i] = new int[] {x, y}; 
				adj[i] = new ArrayList<>();
			}
			
			//generate adjacency list
			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (canGo(coords[i], coords[j])) {
						adj[i].add(j);
						adj[j].add(i);
					}
				}
			}

			//run
			sb.append(bfs(adj, N) ? "happy\n" : "sad\n");
		}
		System.out.print(sb);
	}
	
}