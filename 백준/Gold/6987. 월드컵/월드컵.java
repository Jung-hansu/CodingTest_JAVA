import java.io.*;
import java.util.*;

public class Main {
	
	/** 6C2 조합 */
	private static List<int[]> _6C2 = new ArrayList<>(15);
	
	/** 경기 횟수 검사 */
	private static boolean checkNumOfGames(int[][] scores) {
		int[] scoreCnt = new int[3]; //{win, draw, lose}
		
		for (int team = 0; team < 6; team++) {
			//각 팀이 5경기씩 했는지 확인
			if (scores[team][0] + scores[team][1] + scores[team][2] != 5) {
				return false;
			}
			//전체 경기의 총 승리/무승부/패배 횟수 확인
			for (int i = 0; i < 3; i++) {
				scoreCnt[i] += scores[team][i];
			}
		}
		
		return scoreCnt[0] == scoreCnt[2] && scoreCnt[1] % 2 == 0;
	}
	
	/** 백트래킹 */
	private static boolean isPossible(int[][] scores, int idx) {
		if (idx == 15) {
			for (int[] score : scores) {
				if (score[0] + score[1] + score[2] > 0) {
					return false;
				}
			}
			return true;
		}
		
		int[] t1 = scores[_6C2.get(idx)[0]];
		int[] t2 = scores[_6C2.get(idx)[1]];
		
		for (int i = 0; i <= 2; i++) {
			if (t1[i] * t2[2 - i] > 0) {
				t1[i]--;
				t2[2 - i]--;
				if (isPossible(scores, idx + 1)) {
					return true;
				}
				t2[2 - i]++;
				t1[i]++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][][] games = new int[4][6][3]; //[game][team][win/draw/lose]
		
		//점수를 게임/팀/승리여부 기준으로 분리
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				games[i][j / 3][j % 3] = st.nextToken().charAt(0) - '0';
			}
		}
		
		//조합 생성
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				_6C2.add(new int[] {i, j});
			}
		}
		
		for (int[][] scores : games) {
			sb.append(checkNumOfGames(scores) && isPossible(scores, 0) ? "1 " : "0 ");
		}
		
		System.out.println(sb);
	}
	
}