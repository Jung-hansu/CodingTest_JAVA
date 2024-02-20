import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] inDegrees = new int[N + 1];
		
		//init adj
		List<Integer>[] adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		//parse adj
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			inDegrees[b]++;
		}
		
		//선행 노드가 없는 시작 노드들 모두 큐에 삽입
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				q.add(i);
			}
		}
		
		//선행 노드들이 모두 사라지면 큐에 삽입
		while(!q.isEmpty()) {
			int tmp = q.remove();
			
			for (int v : adj[tmp]) {
				if (--inDegrees[v] == 0) {
					q.add(v);
				}
			}
			sb.append(tmp).append(' ');
		}
		
		System.out.println(sb);
	}
	
}