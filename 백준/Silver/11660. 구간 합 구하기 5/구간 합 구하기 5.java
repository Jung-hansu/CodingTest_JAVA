import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] mat = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				mat[i][j] = mat[i][j-1] + Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				mat[i][j] += mat[i-1][j];
		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
					x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			bw.write((mat[x2][y2] - mat[x1-1][y2]) - (mat[x2][y1-1] - mat[x1-1][y1-1]) + "\n");
		}
		bw.flush();
	}
}