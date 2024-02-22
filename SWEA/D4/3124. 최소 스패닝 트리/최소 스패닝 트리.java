import java.io.*;
import java.util.*;

public class Solution {
	
	private static class Edge implements Comparable<Edge>{
		int A, B, cost;

		public Edge(int a, int b, int cost) {
			A = a;
			B = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	private static int[] parent;
	
	private static boolean union(int a, int b) {
		int x = find(a), y = find(b);
		
		if (x == y) {
			return false;
		}
		parent[Math.max(x, y)] = Math.min(x, y);
		return true;
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static long kruskal(PriorityQueue<Edge> pq, int V) {
		long res = 0;
		
		for (int i = 0; i < V - 1; i++) {
			Edge e = pq.remove();
			
			if (!union(e.A, e.B)) {
				i--;
				continue;
			}
			res += e.cost;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//initialize parent
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			
			//parse edges
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				pq.add(new Edge(a, b, cost));
			}
			
			//run & print
			sb.append('#').append(tc).append(' ').append(kruskal(pq, V)).append('\n');
		}
		System.out.print(sb);
	}

}