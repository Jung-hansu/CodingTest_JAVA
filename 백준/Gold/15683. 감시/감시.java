import java.io.*;
import java.util.*;

public class Main {
	
	private static class CCTV {
		int[] pos;
		int[][] sections;
		
		CCTV(int i, int j){
			int num = field[i][j];
			
			pos = new int[] {i, j};
			if (num == 1) {
				sections = new int[][] {{0}, {1}, {2}, {3}};
			} else if (num == 2) {
				sections = new int[][] {{0, 2}, {1, 3}};
			} else if (num == 3) {
				sections = new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
			} else if (num == 4) {
				sections = new int[][] {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
			} else if (num == 5){
				sections = new int[][] {{0, 1, 2, 3}};
			}
		}
	}
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static List<CCTV> cctvs = new ArrayList<>();
	private static int[][] field;
	private static int N, M;
	private static int minBlank = Integer.MAX_VALUE;

	/** 시야가 닿는 field 변경 **/
	private static void setSight(int[] pos, int[] section, boolean flag) {
		for (int dir : section) {
			int i = pos[0] + D[dir][0];
			int j = pos[1] + D[dir][1];
			
			while (i >= 0 && j >= 0 && i < N && j < M && field[i][j] < 6) {
				//시야가 닿는 영역 표시(중복 횟수도 표시)
				if (field[i][j] <= 0) {
					field[i][j] -= flag ? 1 : -1;
				}
				i += D[dir][0];
				j += D[dir][1];
			}
		}
	}
	
	/** 모든 경우의 수 탐색 **/
	private static void backtrack(int idx) {
		if (idx == cctvs.size()) {
			int blank = 0;
			
			for (int[] row : field) {
				for (int e : row) {
					if (e == 0)
						blank++;
				}
			}
			minBlank = Math.min(minBlank, blank);
			return;
		}
		
		//CCTV를 회전시키는 모든 경우 확인
		CCTV cctv = cctvs.get(idx);
		for (int[] section : cctv.sections) {
			setSight(cctv.pos, section, true);
			backtrack(idx + 1);
			setSight(cctv.pos, section, false);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//parse field
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] > 0 && field[i][j] < 6)
					cctvs.add(new CCTV(i, j));
			}
		}
		
		backtrack(0);
		System.out.println(minBlank);
	}
	
}