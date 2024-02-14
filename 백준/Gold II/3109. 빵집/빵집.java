import java.io.*;
import java.util.*;

public class Main {

	private static final int[] D = {-1, 0, 1};
	private static boolean[][] field;
	private static int R, C;
	private static int cnt = 0;
	
	private static boolean dfs(int i, int j) {
		field[i][j] = true;
		
		if (j == C - 1) {
			cnt++;
			return true;
		}
		
		for (int di : D) {
			if (i + di < 0 || i + di >= R) {
				continue;
			}
			if (!field[i + di][j + 1]) {
				if (dfs(i + di, j + 1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//parsing
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'x')
				field[i][j] = true;
			}
		}
		
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
	
}