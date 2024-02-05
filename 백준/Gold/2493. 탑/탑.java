import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] towers = new int[N];

		//parsing
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		//run
		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek()[1] <= towers[i]) {
				towers[stack.pop()[0]] = i + 1;
			}
			stack.push(new int[] {i, towers[i]});
		}
		while (!stack.isEmpty()) {
			towers[stack.pop()[0]] = 0;
		}
		
		//print
		for (int n : towers) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}
	
}