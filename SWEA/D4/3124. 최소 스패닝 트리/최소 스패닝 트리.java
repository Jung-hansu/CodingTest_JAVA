import java.io.*;
import java.util.*;

public class Solution {
	
	private static List<int[]>[] adj;

	private static long prim(int V) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		BitSet selected = new BitSet();
		long res = 0;
		
		selected.set(1);
		for (int[] e : adj[1]) {
			pq.add(e);
		}
		
		while(--V > 0) {
			int[] edge;
			do {
				edge = pq.remove();
			} while (selected.get(edge[0]));
			
			res += edge[1];
			selected.set(edge[0]);
			for (int[] e : adj[edge[0]]) {
				if (!selected.get(e[0])) {
					pq.add(e);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//initialize adjacency list
			adj = new List[V + 1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			//parse edges
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
			
				adj[a].add(new int[] {b, cost});
				adj[b].add(new int[] {a, cost});
			}
			
			//run & print
			sb.append('#').append(tc).append(' ').append(prim(V)).append('\n');
		}
		System.out.print(sb);
	}

}