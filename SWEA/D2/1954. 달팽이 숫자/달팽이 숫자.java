import java.io.*;

public class Solution {
	
	private static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private static void goSnail(int[][] field, int N) {
		int i = 0, j = 0, num = 1, dir = 0;
		
		while (field[i][j] == 0) {
			int I = i + D[dir][0];
			int J = j + D[dir][1];
			
			field[i][j] = num++;
			
			if (I < 0 || I >= N || J < 0 || J >= N || field[I][J] > 0) {
				dir = (dir + 1) % 4;
			}
			i += D[dir][0];
			j += D[dir][1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int[][] field = new int[N][N];
        	
        	sb.append('#').append(tc).append('\n');
        	
        	if (N == 1) {
        		sb.append("1 \n");
        		continue;
        	}
        	
        	goSnail(field, N);
        	for (int[] row : field) {
        		for (int e : row) {
        			sb.append(e).append(' ');
        		}
        		sb.append('\n');
        	}
        }
        System.out.println(sb);
    }
	
}