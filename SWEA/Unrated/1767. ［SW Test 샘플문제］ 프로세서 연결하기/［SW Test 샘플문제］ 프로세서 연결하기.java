import java.io.*;
import java.util.*;

public class Solution {

	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static List<int[]> processes;
	private static int[][] field;
	private static int N, maxConnected, connected, minLen, totalLen;
	
	private static boolean isInField(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N;
	}
	
	private static void connect(int[] process, int[] d, boolean flag) {
		int i = process[0] + d[0], j = process[1] + d[1];
		
		while (isInField(i, j)) {
			field[i][j] = flag ? 2 : 0;
			totalLen += flag ? 1 : -1;
			
			i += d[0];
			j += d[1];
		}
		connected += flag ? 1 : -1;
	}
	
	private static boolean canConnect(int[] process, int[] d) {
		int i = process[0] + d[0], j = process[1] + d[1];
		
		while (field[i][j] == 0) {
			i += d[0];
			j += d[1];
			
			if (!isInField(i, j)) {
				return true;
			}
		}
		return false;
	}
	
	private static void backtrack(int idx) {
		if (idx == processes.size()) {
			if (maxConnected == connected) {
				minLen = Math.min(minLen, totalLen);
			}
			else if (maxConnected < connected) {
				maxConnected = connected;
				minLen = totalLen;
			}
			return;
		}
		
		int[] process = processes.get(idx);
		
		for (int[] d : D) {
			if (!canConnect(process, d)) {
				continue;
			}
			connect(process, d, true);
			
			backtrack(idx + 1);
			if (maxConnected == connected) {
				minLen = Math.min(minLen, totalLen);
			}
			else if (maxConnected < connected) {
				maxConnected = connected;
				minLen = totalLen;
			}
			
			connect(process, d, false);
		}
		
		//하나도 연결이 안되는 경우
		backtrack(idx + 1);
	}
	
	private static int getShortestLine() {
		maxConnected = 0;
		connected = 0;
		minLen = Integer.MAX_VALUE;
		totalLen = 0;
		
		backtrack(0);
		return minLen;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			processes = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			
			field = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
					if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && field[i][j] == 1) {
						processes.add(new int[] {i, j});
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(getShortestLine()).append('\n');
		}
		System.out.print(sb);
	}

}