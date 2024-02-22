import java.io.*;
import java.util.*;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	private static int N, minDiff = INF;
	private static int[] population;
	private static int[][] adjList;
	private static int[] comb = new int[10];
	
	private static int getMinDiff(int size) {
		Queue<Integer> group1 = new ArrayDeque<>();
		Queue<Integer> group2 = new ArrayDeque<>();
		int[] revComb = new int[N - size];
		
		//comb의 여집합 revComb 생성
		int idx = 0;
		for (int n = 1; n <= N; n++) {
			if (Arrays.binarySearch(comb, 0, size, n) < 0) {
				revComb[idx++] = n;
			}
		}
		
		//각 집합에 대해 BFS
		group1.add(comb[0]);
		group2.add(revComb[0]);
		int sum1 = population[comb[0]];
		int sum2 = population[revComb[0]];
		int visited1 = (1 << comb[0]);
		int visited2 = (1 << revComb[0]);
		while(!group1.isEmpty() || !group2.isEmpty()) {
			if (!group1.isEmpty()) {
				int tmp = group1.remove();
				
				for (int v : adjList[tmp]) {
					if (Arrays.binarySearch(comb, 0, size, v) >= 0 && (visited1 & (1 << v)) == 0) {
						visited1 |= (1 << v);
						group1.add(v);
						sum1 += population[v];
					}
				}
			}
			if (!group2.isEmpty()) {
				int tmp = group2.remove();
				
				for (int v : adjList[tmp]) {
					if (Arrays.binarySearch(revComb, 0, N - size, v) >= 0 && (visited2 & (1 << v)) == 0) {
						visited2 |= (1 << v);
						group2.add(v);
						sum2 += population[v];
					}
				}
			}
		}

		//모든 노드가 연결돼있는지 확인
		if (Integer.bitCount(visited1) == size && Integer.bitCount(visited2) == N - size) {
			return Math.abs(sum1 - sum2);
		}
		return INF;
	}
	
	private static void runForAllCombs(int size, int num, int idx) {
		if (idx == size) {
			minDiff = Math.min(minDiff, getMinDiff(size));
			return;
		}

		for (int n = num + 1; n <= N - size + idx + 1; n++) {
			comb[idx] = n;
			runForAllCombs(size, n, idx + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//parse population
		population = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		//parse adjacency list
		adjList = new int[N + 1][];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			
			adjList[n] = new int[len];
			for (int i = 0; i < len; i++) {
				adjList[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		//run (홀수면 [N/2]까지 진행)
		for (int size = 1; size <= N; size++) {
			runForAllCombs(size, 1, 0);
		}

		//print
		System.out.println(minDiff == INF ? -1 : minDiff);
	}
	
}