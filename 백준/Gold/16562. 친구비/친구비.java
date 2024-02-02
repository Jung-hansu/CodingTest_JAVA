import java.io.*;
import java.util.*;


public class Main {
	
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
		Map<Integer, Integer> groupCosts = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
			K = Integer.parseInt(st.nextToken()), cost = 0;
		int[] costs = new int[N + 1];
		
		//init parent
		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		//input parsing
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		//union (grouping)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		//각 그룹의 최소 친구비 계산 
		for (int i = 1; i <= N; i++) {
			int group = find(i);
			groupCosts.put(group, Math.min(costs[i], groupCosts.getOrDefault(group, Integer.MAX_VALUE)));
		}
		
		//각 그룹 모두 친구로 만듦
		for (int val : groupCosts.values()) {
			if ((cost += val) > K) {
				System.out.println("Oh no");
				return;
			}
		}
		System.out.println(cost);
	}
	
}