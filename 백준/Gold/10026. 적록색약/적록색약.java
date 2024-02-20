import java.io.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static boolean[][] visited;
	private static char[][] picture;
	private static int N;
	
	private static void dfs(char c, int i, int j) {
		visited[i][j] = true;
		
		for (int[] dir : D) {
			int nextI = i + dir[0];
			int nextJ = j + dir[1];
			
			if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= N) {
				continue;
			}
			if (!visited[nextI][nextJ] && picture[nextI][nextJ] == c) {
				dfs(c, nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer1 = 0, answer2 = 0;
		N = Integer.parseInt(br.readLine());
		
		picture = new char[N][N];
		for (int i = 0; i < N; i++){
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(picture[i][j], i, j);
					answer1++;
				}
			}
		}
		
		//맵 세팅
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (picture[i][j] == 'G') {
					picture[i][j] = 'R';
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(picture[i][j], i, j);
					answer2++;
				}
			}
		}
		
		System.out.println(answer1 + " " + answer2);
	}
	
}