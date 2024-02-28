import java.io.*;
import java.util.*;

public class Main {
	
	private static int[][] field;
	private static int N, cnt = 0;
	
	//오른쪽=0, 대각=1, 아래=2
	private static void dfs(int i, int j, int dir) {
		if (i == N - 1 && j == N - 1) {
			cnt++;
			return;
		}
		
		if (dir < 2 && j + 1 < N && field[i][j + 1] == 0) {
			dfs(i, j + 1, 0);
		}
		if (i + 1 < N && j + 1 < N && field[i + 1][j] == 0 && field[i][j + 1] == 0 && field[i + 1][j + 1] == 0) {
			dfs(i + 1, j + 1, 1);
		}
		if (dir > 0 && i + 1 < N && field[i + 1][j] == 0) {
			dfs(i + 1, j, 2);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//parse field
		field = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(cnt);
	}
	
}