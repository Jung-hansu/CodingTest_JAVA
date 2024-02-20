import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int[][] field;
	private static int N, M;
	
	private static boolean isOver() {
		for (int[] row : field) {
			for (int e : row) {
				if (e > 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int meltDown() {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> melted = new ArrayList<>();
		boolean[][] visited = new boolean[N + 2][M + 2];
		
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.remove();
			
			for (int[] dir : D) {
				int nextI = tmp[0] + dir[0];
				int nextJ = tmp[1] + dir[1];
				
				if (nextI < 0 || nextJ < 0 || nextI > N || nextJ > M) {
					continue;
				}
				
				//get peels
				if (field[nextI][nextJ] == 1) {
					melted.add(new int[] {nextI, nextJ});
				}
				else if (!visited[nextI][nextJ]){
					visited[nextI][nextJ] = true;
					q.add(new int[] {nextI, nextJ});
				}
			}
		}
		
		//peeling
		int cnt = 0;
		for (int[] peel : melted) {
			if (field[peel[0]][peel[1]] == 1) {
				cnt++;
			}
			field[peel[0]][peel[1]] = 0;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int time = 0, lastCheese = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//parse
		field = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//run
		do {
			time++;
			lastCheese = meltDown();
		} while (!isOver());
		
		//print
		System.out.println(time);
		System.out.println(lastCheese);
	}
	
}