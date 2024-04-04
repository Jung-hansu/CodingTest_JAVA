import java.io.*;
import java.util.*;

public class Main {
	
	private static class FineDust{
		int i, j, amount;
		
		public FineDust(int i, int j, int amount) {
			this.i = i;
			this.j = j;
			this.amount = amount;
		}
		
		public void expand() {
			//확장이 일어나지 않음
			if (amount < 5) {
				return;
			}
			
			//사방 확장
			for (int[] d : D) {
				int nextI = i + d[0], nextJ = j + d[1];
				
				if (nextI >= 0 && nextJ >= 0 && nextI < R && nextJ < C && field[nextI][nextJ] >= 0) {
					field[nextI][nextJ] += amount / 5;
					field[i][j] -= amount / 5;
				}
			}
		}
	}
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static final Queue<FineDust> fineDusts = new ArrayDeque<>();
	private static int[][] field;
	private static int R, C, T;
	private static int totalDusts;
	private static int airPurifier;
	
	private static void expandAll() {
		//각 미세먼지 기록
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (field[i][j] > 0) {
					fineDusts.add(new FineDust(i, j, field[i][j]));
				}
			}
		}
		
		//미세먼지 일괄 확장
		while (!fineDusts.isEmpty()) {
			fineDusts.remove().expand();
		}
	}
	
	private static void circulation() {
		//공기청정기에 흡수될 먼지 계산
		totalDusts -= field[airPurifier - 2][0];
		totalDusts -= field[airPurifier + 1][0];
		
		//upside circulation
		for (int i = airPurifier - 2; i > 0; i--) {
			field[i][0] = field[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			field[0][j] = field[0][j + 1];
		}
		for (int i = 0; i < airPurifier - 1; i++) {
			field[i][C - 1] = field[i + 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			field[airPurifier - 1][j] = field[airPurifier - 1][j - 1];
		}
		field[airPurifier - 1][1] = 0;
		
		//downside circulation
		for (int i = airPurifier + 1; i < R - 1; i++) {
			field[i][0] = field[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			field[R - 1][j] = field[R - 1][j + 1];
		}
		for (int i = R - 1; i > airPurifier; i--) {
			field[i][C - 1] = field[i - 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			field[airPurifier][j] = field[airPurifier][j - 1];
		}
		field[airPurifier][1] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		field = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				
				if (field[i][j] < 0) {
					airPurifier = i;
				} else if (field[i][j] > 0) {
					totalDusts += field[i][j];
				}
				
			}
		}

		while (T-- > 0) {
			expandAll();
			circulation();
		}
		System.out.println(totalDusts);
	}
	
}