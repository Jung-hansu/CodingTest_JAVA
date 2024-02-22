import java.io.*;
import java.util.*;

public class Solution {
	
	private static List<Edge>[] adj;
	
	private static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

	private static long prim(int V) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		BitSet selected = new BitSet();
		long res = 0;
		
		selected.set(1);
		for (Edge e : adj[1]) {
			pq.add(e);
		}
		
		while(--V > 0) {
			Edge edge;
			do {
				edge = pq.remove();
			} while (selected.get(edge.to));
			
			res += edge.cost;
			selected.set(edge.to);
			for (Edge e : adj[edge.to]) {
				if (!selected.get(e.to)) {
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
			
				adj[a].add(new Edge(b, cost));
				adj[b].add(new Edge(a, cost));
			}
			
			//run & print
			sb.append('#').append(tc).append(' ').append(prim(V)).append('\n');
		}
		System.out.print(sb);
	}

}