import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static final int[][][] SECTIONS = {
			{{0}, {1}, {2}, {3}},
			{{0, 2}, {1, 3}},
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
			{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
			{{0, 1, 2, 3}}
	};
	
	private static class CCTV {
		int[] pos;
		int[][] sections;
		
		CCTV(int i, int j){
			this.pos = new int[] {i, j};
			this.sections = SECTIONS[field[i][j] - 1];
		}
	}
	
	private static List<CCTV> cctvs = new ArrayList<>();
	private static int[][] field;
	private static int N, M;
	private static int initBlank = 0, minBlank = Integer.MAX_VALUE;

	/** 시야가 닿는 field 변경 **/
	private static int setSight(int[] pos, int[] section, boolean flag) {
		int filled = 0;
		
		for (int dir : section) {
			int i = pos[0] + D[dir][0];
			int j = pos[1] + D[dir][1];
			
			while (i >= 0 && j >= 0 && i < N && j < M && field[i][j] < 6) {
				//시야가 닿는 영역 표시(중복 횟수도 표시)
				if (field[i][j] <= 0) {
					if (field[i][j] == 0) {
						filled++;
					}
					field[i][j] -= flag ? 1 : -1;
				}
				i += D[dir][0];
				j += D[dir][1];
			}
		}
		return filled;
	}
	
	/** 모든 경우의 수 탐색 **/
	private static void backtrack(int idx, int filled) {
		if (idx == cctvs.size()) {
			minBlank = Math.min(minBlank, initBlank - filled);
			return;
		}
		
		//CCTV를 회전시키는 모든 경우 확인
		CCTV cctv = cctvs.get(idx);
		for (int[] section : cctv.sections) {
			int tmp = setSight(cctv.pos, section, true);
			backtrack(idx + 1, filled + tmp);
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
				if (field[i][j] == 0) {
					initBlank++;
				}
				else if (field[i][j] < 6)
					cctvs.add(new CCTV(i, j));
			}
		}
		
		backtrack(0, 0);
		System.out.println(minBlank);
	}
	
}