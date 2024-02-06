import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] towers = new int[N];

		//parsing
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		//run
		for (int i = N - 1; i >= 0; i--) {
			while (!dq.isEmpty() && dq.peekLast()[1] <= towers[i]) {
				towers[dq.pollLast()[0]] = i + 1;
			}
			dq.addLast(new int[] {i, towers[i]});
		}
		while (!dq.isEmpty()) {
			towers[dq.pollLast()[0]] = 0;
		}
		
		//print
		for (int n : towers) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}
	
}