import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static int[][] field;
	
	private static void swap(int i1, int j1, int i2, int j2) {
		field[i1][j1] ^= field[i2][j2];
		field[i2][j2] ^= field[i1][j1];
		field[i1][j1] ^= field[i2][j2];
	}
	
	private static void operate(int op) {
		switch(op) {
		case 1: operation1(); break;
		case 2: operation2(); break;
		case 3: operation3(); break;
		case 4: operation4(); break;
		case 5: operation5(); break;
		case 6: operation6(); break;
		}
	}
	
	private static void operation1() {
		int N = field.length, M = field[0].length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				swap(i, j, N - i - 1, j);
			}
		}
	}
	
	private static void operation2() {
		int N = field.length, M = field[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				swap(i, j, i, M - j - 1);
			}
		}
	}
	
	private static void operation3() {
		int N = field.length, M = field[0].length;
		int[][] newField = new int[M][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newField[j][N - i - 1] = field[i][j];
			}
		}
		field = newField;
	}
	
	private static void operation4() {
		int N = field.length, M = field[0].length;
		int[][] newField = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newField[M - j - 1][i] = field[i][j];
			}
		}
		field = newField;
	}
	
	private static void operation5() {
		int N = field.length, M = field[0].length;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = field[i][j];
				field[i][j] = field[i + N / 2][j];
				field[i + N / 2][j] = field[i + N / 2][j + M / 2];
				field[i + N / 2][j + M / 2] = field[i][j + M / 2];
				field[i][j + M / 2] = tmp;
			}
		}
	}
	
	private static void operation6() {
		int N = field.length, M = field[0].length;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = field[i][j];
				field[i][j] = field[i][j + M / 2];
				field[i][j + M / 2] = field[i + N / 2][j + M / 2];
				field[i + N / 2][j + M / 2] = field[i + N / 2][j];
				field[i + N / 2][j] = tmp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
			M = Integer.parseInt(st.nextToken()),
			R = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		//parsing
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//run
		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			operate(Integer.parseInt(st.nextToken()));
		}
		
		//print
		for (int[] row : field) {
			for (int n : row) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
}