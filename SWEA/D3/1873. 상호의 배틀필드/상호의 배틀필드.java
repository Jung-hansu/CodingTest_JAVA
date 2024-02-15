import java.io.*;
import java.util.*;

public class Solution {
	
	private static int H, W;
	private static char[][] field;
	private static String op;
	
	private static void play(int[] pos) {
		int i = pos[0], j = pos[1];
		
		for (int n = 0; n < op.length(); n++) {
			switch(op.charAt(n)) {
				case 'U':
					if (i > 0 && field[i - 1][j] == '.') {
						field[i--][j] = '.';
					}
					field[i][j] = '^';
					break;
				case 'D':
					if (i < H - 1 && field[i + 1][j] == '.') {
						field[i++][j] = '.';
					}
					field[i][j] = 'v';
					break;
				case 'L':
					if (j > 0 && field[i][j - 1] == '.') {
						field[i][j--] = '.';
					}
					field[i][j] = '<';
					break;
				case 'R':
					if (j < W - 1 && field[i][j + 1] == '.') {
						field[i][j++] = '.';
					}
					field[i][j] = '>';
					break;
				case 'S':
					int I = i, J = j;
					
					switch(field[I][J]) {
						case '^': 
							while (I >= 0 && (field[I][J] != '#' && field[I][J] != '*')) {
								I--;
							}
							break;
						case 'v':
							while (I < H  && (field[I][J] != '#' && field[I][J] != '*')) {
								I++;
							}
							break;
						case '<':
							while (J >= 0 && (field[I][J] != '#' && field[I][J] != '*')) {
								J--;
							}
							break;
						case '>':
							while (J < W && (field[I][J] != '#' && field[I][J] != '*')) {
								J++;
							}
							break;
					}
					if (I >= 0 && J >= 0 && I < H && J < W && field[I][J] == '*') {
						field[I][J] = '.';
					}
					break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] pos = null;
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				char c;
				for (int j = 0; j < W; j++) {
					c = field[i][j] = line.charAt(j);
					if (c == '>' || c == '<' || c == '^' || c == 'v') {
						pos = new int[] {i, j};
					}
				}
			}
			br.readLine();
			op = br.readLine();
			
			play(pos);
			sb.append('#').append(tc).append(' ');
			for (char[] row : field) {
				for (char c : row) {
					sb.append(c);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

}