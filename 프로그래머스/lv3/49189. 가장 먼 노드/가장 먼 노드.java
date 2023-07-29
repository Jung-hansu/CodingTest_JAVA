import java.util.*;

class Solution {
	public int solution(int n, int[][] edge) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer>[] adj = new LinkedList[n+1];
		boolean[] check = new boolean[n+1];
		int answer = 0;

		//Make adjacency list
		for (int i = 1; i < adj.length; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : edge){
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}

		//BFS
		q.add(1);
		check[1] = true;
		while (!q.isEmpty()){
			answer = q.size();
			for (int i = 0; i < answer; i++)
				for (int neighbor : adj[q.remove()])
					if (!check[neighbor]){
						q.add(neighbor);
						check[neighbor] = true;
					}
		}
		return answer;
	}
}