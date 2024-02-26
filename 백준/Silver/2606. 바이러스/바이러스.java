import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] edge = new List[N+1];
		for(int i =1; i<=N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		int answer = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(1);
		while(!deque.isEmpty()) {
			int curr = deque.removeFirst();
			for (Integer num : edge[curr]) {
				if(!visited[num]) {
					visited[num] = true;
					answer+=1;
					deque.add(num);
				}
			}
		}
		System.out.println(answer);
	}
}