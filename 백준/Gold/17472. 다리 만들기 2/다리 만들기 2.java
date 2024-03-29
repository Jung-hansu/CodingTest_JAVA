import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static final int INF = 1_000_000_000;
	private static int[][] field;
	private static int[][] adj;
	private static int[] parent;
	private static int N, M;
	
	private static class Edge implements Comparable<Edge>{
		int i1, i2;
		int cost;

		public Edge(int i1, int i2, int cost) {
			this.i1 = i1;
			this.i2 = i2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}
	
	private static boolean union(Edge e) {
		int p1 = find(e.i1), p2 = find(e.i2);
		
		if (p1 == p2) {
			return false;
		}
		parent[Math.max(p1, p2)] = Math.min(p1, p2);
		return true;
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void bfs(boolean[][] visited, int si, int sj, int islandNum) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(si * M + sj);
		field[si][sj] = islandNum;
		visited[si][sj] = true;
		while (!q.isEmpty()) {
			int idx = q.remove();
			int i = idx / M, j = idx % M;
			
			for (int[] d : D) {
				int nextI = i + d[0];
				int nextJ = j + d[1];
				
				if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M ||
						visited[nextI][nextJ] || field[nextI][nextJ] == 0) {
					continue;
				}
				visited[nextI][nextJ] = true;
				field[nextI][nextJ] = islandNum;
				q.add(nextI * M + nextJ);
			}
		}
	}
	
	private static void generateAdjMatrix() {
		boolean[][] visited = new boolean[N][M];
		int iNum = 1;
		
		//islands numbering
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && field[i][j] == 1) {
					bfs(visited, i, j, iNum++);
				}
			}
		}
		
		//initialize parent
		parent = new int[iNum];
		for (int i = 0; i < iNum; i++) {
			parent[i] = i;
		}
		
		//initialize adj matrix
		adj = new int[iNum][iNum];
		for (int i = 0; i < iNum; i++) {
			for (int j = 0; j < iNum; j++) {
				adj[i][j] = INF;
			}
		}
		
		//generate adj matrix - row
		for (int i = 0; i < N; i++) {
			int i1 = 0, dist = 0;
			for (int j = 0; j < M; j++) {
				
				if (field[i][j] > 0) {
					int i2 = field[i][j];
					
					if (i1 > 0 && i1 != i2 && dist > 1) {
						adj[i1][i2] = adj[i2][i1] = Math.min(adj[i1][i2], dist); 
					}
					i1 = i2;
					dist = 0;
				}
				else {
					dist++;
				}
				
			}
		}
		
		//generate adj matrix - col
		for (int j = 0; j < M; j++) {
			int i1 = 0, dist = 0;
			for (int i = 0; i < N; i++) {
				
				if (field[i][j] > 0) {
					int i2 = field[i][j];
					
					if (i1 > 0 && i1 != i2 && dist > 1) {
						adj[i1][i2] = adj[i2][i1] = Math.min(adj[i1][i2], dist); 
					}
					i1 = i2;
					dist = 0;
				}
				else {
					dist++;
				}
				
			}
		}
	}

	private static int kruskal() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int iNum = adj.length, bitSet = 0, res = 0;
		
		//convert adj-matrix to edge-list
		for (int i = 1; i < iNum - 1; i++) {
			for (int j = i + 1; j < iNum; j++) {
				if (adj[i][j] != INF) {
					pq.add(new Edge(i, j, adj[i][j]));
				}
			}
		}
		
		//run kruskal
		int edge = 0;
		while (!pq.isEmpty() && edge < iNum - 1) {
			Edge e = pq.remove();
			
			if (union(e)) {
				edge++;
				res += e.cost;
			}
			
			if (edge == iNum - 2) {
				return res;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//parse field
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		generateAdjMatrix();
		System.out.println(kruskal());
		
	}
	
}