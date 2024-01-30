import java.io.*;
import java.util.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	private static int N, M;
	
	private static void permutation(boolean[] check, int idx) {
		if (idx == M) {
			for (int n : arr) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) 
			if (!check[i]){
				arr[idx] = i;
				check[i] = true;
				permutation(check, idx + 1);
				check[i] = false;
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		permutation(new boolean[N + 1], 0);
		System.out.println(sb);
	}
	
}