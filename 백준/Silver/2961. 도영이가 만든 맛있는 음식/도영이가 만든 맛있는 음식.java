import java.io.*;
import java.util.*;

public class Main {

	private static int[][] ingredients;
	private static int minDiff = Integer.MAX_VALUE;
	private static int N;
	
	private static void dfs(int prod, int sum, int idx, boolean flag) {
		if (idx > N) {
			return;
		}
		
		if (flag) {
			minDiff = Math.min(minDiff, Math.abs(prod - sum));
		}
		for (int i = idx; i < N; i++) {
			dfs(prod * ingredients[i][0], sum + ingredients[i][1], i + 1, flag || true);
			dfs(prod, sum, i + 1, flag || false);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredients[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		dfs(1, 0, 0, false);
		System.out.println(minDiff);
	}
	
}