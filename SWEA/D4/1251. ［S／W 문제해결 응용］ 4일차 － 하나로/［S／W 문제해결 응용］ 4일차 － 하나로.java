import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int p1, p2;
	long cost;
	
	public Edge(int p1, int p2, long cost) {
		this.p1 = p1;
		this.p2 = p2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return cost < o.cost ? -1 : cost > o.cost ? 1 : 0;
	}
	
	@Override
	public String toString() {
		return "\n"+p1+"-"+p2+": "+cost;
	}
}

public class Solution {
	
	private static int[] parent;
	
	private static void union(int x, int y) {
		parent[Math.max(x, y)] = Math.min(x, y);
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static long getDist(int[] p1, int[] p2) {
		return (long)(p1[0] - p2[0]) * (p1[0] - p2[0]) + (long)(p1[1] - p2[1]) * (p1[1] - p2[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Edge> edges = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			int[][] islands = new int[N][];
			double E, total = 0;
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());

			//initialize parent
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			//parse islands
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				
				islands[i] = new int[] {x, y};
			}
			
			//add all edges
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edges.add(new Edge(i, j, getDist(islands[i], islands[j])));
				}
			}
			
			//kruskal
			int cnt = 0;
			while (!edges.isEmpty()) {
				Edge e = edges.remove();
				if (find(e.p1) == find(e.p2)) {
					continue;
				}
				
				total += e.cost;
				union(find(e.p1), find(e.p2));
				if (++cnt == N - 1) {
					break;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(Math.round(E * total)).append('\n');
		}
		System.out.println(sb);
	}

}
