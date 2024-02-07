import java.io.*;
import java.util.*;

public class Solution {
	
	private static boolean isMovable(int[][] rooms, int[] now, int[] prev) {
		return now[0] == prev[0] + 1 &&
				(now[1] == prev[1] && Math.abs(now[2] - prev[2]) == 1 ||
				now[2] == prev[2] && Math.abs(now[1] - prev[1]) == 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] rooms = new int[N + 1][N + 1];
			List<int[]> numLoc = new ArrayList<>();
			
			//parsing
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
					numLoc.add(new int[] {rooms[i][j], i, j});
				}
			}
			
			//run
			int res = 1, max = 0, maxIdx = 0;
			
			numLoc.sort(Comparator.comparingInt(o -> -o[0]));
			for (int i = 0; i < N * N; i++) {
				if (i < N * N - 1 && isMovable(rooms, numLoc.get(i), numLoc.get(i + 1))) {
					res++;
				}
				else {
					if (max <= res) {
						max = res;
						maxIdx = numLoc.get(i)[0];
					}
					res = 1;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(maxIdx).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}
	
}