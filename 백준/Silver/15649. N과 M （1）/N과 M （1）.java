import java.io.*;
import java.util.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static Stack<Integer> stack = new Stack<>();
	
	private static void permutation(boolean[] check, int N, int M) {
		if (stack.size() == M) {
			stack.forEach(n -> sb.append(n).append(' '));
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) 
			if (!check[i]){
				stack.push(i);
				check[i] = true;
				permutation(check, N, M);
				check[i] = false;
				stack.pop();
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
			M = Integer.parseInt(st.nextToken());
		
		permutation(new boolean[N + 1], N, M);
		System.out.println(sb);
	}
	
}