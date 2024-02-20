import java.io.*;
import java.util.*;

public class Solution {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	private static int bfs(int[][] miro, int[] sp) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(sp);
		while(!q.isEmpty()) {
			int[] pos = q.remove();
			
			for (int[] dir : D) {
				int nextI = pos[0] + dir[0];
				int nextJ = pos[1] + dir[1];
				
				if (nextI < 0 || nextJ < 0 || nextI > 99 || nextJ > 99) {
					continue;
				}
				if (miro[nextI][nextJ] == 3) {
					return 1;
				}
				if (miro[nextI][nextJ] == 0) {
					miro[nextI][nextJ] = 1;
					q.add(new int[] {nextI, nextJ});
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] miro = new int[100][100];
			int[] sp = null;
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					miro[i][j] = s.charAt(j) & 15;
					
					if (miro[i][j] == 2) {
						sp = new int[] {i, j};
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(bfs(miro, sp)).append('\n');
		}
		System.out.println(sb);
	}

}