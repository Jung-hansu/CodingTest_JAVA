import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
			M = Integer.parseInt(st.nextToken()),
			R = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		
		//parsing
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int peel = Math.min(Math.min(i, N - i - 1), Math.min(j, M - j - 1));
				int I = i, J = j;

				for (int r = 0; r < R; r++) {
					int d;
					
					if (J == peel && I != N - 1 - peel)
						d = 0;
					else if (I == N - 1 - peel && J != M - 1 - peel)
						d = 1;
					else if (J == M - 1 - peel && I != peel)
						d = 2;
					else
						d = 3;
					
					I += D[d][0];
					J += D[d][1];
				}
				field[I][J] = Integer.parseInt(st.nextToken());
			}
		}
		
		//print
		for (int[] row : field) {
			for (int e : row) {
				sb.append(e).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
}