import java.io.*;

public class Main {
	
	private static int[][] D = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	private static int[][] board = new int[20][20];
	
	private static boolean isInside(int i, int j) {
		return i >= 0 && j >= 0 && i < 20 && j < 20;
	}
	
	private static boolean isOver(int[] pos) {
		for (int[] d : D) {
			int preI = pos[0] - d[0], preJ = pos[1] - d[1];
			int I = pos[0] + d[0], J = pos[1] + d[1], len = 1;
			
			// 직선의 시작부분인지 확인
			if (isInside(preI, preJ) && board[preI][preJ] == board[pos[0]][pos[1]])
				continue;
			
			// 연속된 돌의 수 확인
			while (isInside(I, J) && board[I][J] == board[pos[0]][pos[1]]) {
				I += d[0];
				J += d[1];
				len++;
			}
			if (len == 5)
				return true;
		}
		
		return false;
	}
	
	private static void getWinner(int[][] board) {
		for (int j = 1; j < 20; j++)
		    for (int i = 1; i < 20; i++)
				if (board[i][j] > 0 && isOver(new int[] {i, j})) {
					System.out.println(board[i][j] + "\n" + i + " " + j);
					return;
				}
		System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i < 20; i++) {
			String line = br.readLine();
			for (int j = 1; j < 20; j++)
				board[i][j] = line.charAt(2 * j - 2) - '0';
		}
		
		getWinner(board);
	}
}