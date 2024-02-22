import java.io.*;
import java.util.*;

public class Solution {
	
	private static int getLastCall(Map<Integer, Set<Integer>> adj, int start) {
		Queue<Integer> q = new ArrayDeque<>();
		BitSet visited = new BitSet();
		int lastCall = 0;
		
		q.add(start);
		visited.set(start);
		while(!q.isEmpty()) {
			int biggest = 0, size = q.size();
			
			while (size-- > 0) {
				int tmp = q.remove();
				
				if (adj.containsKey(tmp)) {
					for (int v : adj.get(tmp)) {
						if (!visited.get(v)) {
							visited.set(v);
							q.add(v);
							biggest = Math.max(biggest, v);
						}
					}
				}
				
				//마지막 노드가 아닐 때만 업데이트
				if (biggest > 0)
					lastCall = biggest;
			}
		}
		
		return lastCall;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			Map<Integer, Set<Integer>> adj = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj.putIfAbsent(from, new HashSet<>());
				adj.get(from).add(to);
			}
			
			sb.append('#').append(tc).append(' ').append(getLastCall(adj, start)).append('\n');
		}
		System.out.println(sb);
	}

}