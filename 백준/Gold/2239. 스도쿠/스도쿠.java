import java.io.*;
import java.util.*;

public class Main {
	
	private static List<Integer> zeros = new ArrayList<>();
	private static int[][] sudoku = new int[9][9];
	private static int[] rows = new int[9];
	private static int[] cols = new int[9];
	private static int[] boxes = new int[9];
	
	private static void printSudoku() {
		StringBuilder sb = new StringBuilder();
		
		for (int[] row : sudoku) {
			for (int n : row)
				sb.append(n);
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	private static void setNumber(int i, int j, int num) {
		sudoku[i][j] = (sudoku[i][j] == 0 ? num : 0);
		rows[i] ^= 1 << num - 1;
		cols[j] ^= 1 << num - 1;
		boxes[i / 3 * 3 + j / 3] ^= 1 << num - 1;
	}
	
	private static boolean isSettable(int i, int j, int num) {
		return (rows[i] & (1 << num - 1)) == 0 &&
				(cols[j] & (1 << num - 1)) == 0 &&
				(boxes[i / 3 * 3 + j / 3] & (1 << num - 1)) == 0;
	}
	
	private static void backtrack(int depth) {
		if (depth == zeros.size()) {
			printSudoku();
			System.exit(0);
		}
		
		for (int n = 1; n <= 9; n++) {
			int i = zeros.get(depth) / 9;
			int j = zeros.get(depth) % 9;
			if (isSettable(i, j, n)) {
				setNumber(i, j, n);
				backtrack(depth + 1);
				setNumber(i, j, n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) & 15;
				
				if (sudoku[i][j] > 0) {
					rows[i] |= 1 << sudoku[i][j] - 1;
					cols[j] |= 1 << sudoku[i][j] - 1;
					boxes[i / 3 * 3 + j / 3] |= 1 << sudoku[i][j] - 1;
				} else {
					zeros.add(i * 9 + j);
				}
				
			}
		}
		backtrack(0);
	}
	
}