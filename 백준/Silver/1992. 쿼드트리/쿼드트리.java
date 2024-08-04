import java.io.*;
import java.util.*;

public class Main {

	private static final StringBuilder sb = new StringBuilder();
	private static char[][] screen;
	
	private static boolean isCompressible(int N, int i, int j) {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (screen[i + n][j + m] != screen[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void getQuadTree(int N, int i, int j) {
		if (N == 1 || isCompressible(N, i, j)) {
			sb.append(screen[i][j]);
			return;
		}
		
		sb.append('(');
		getQuadTree(N / 2, i, j);
		getQuadTree(N / 2, i, j + N / 2);
		getQuadTree(N / 2, i + N / 2, j);
		getQuadTree(N / 2, i + N / 2, j + N / 2);
		sb.append(')');
	}
	
	private static String compress(int N) {
		getQuadTree(N, 0, 0);
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		screen = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				screen[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(compress(N));
	}
	
}