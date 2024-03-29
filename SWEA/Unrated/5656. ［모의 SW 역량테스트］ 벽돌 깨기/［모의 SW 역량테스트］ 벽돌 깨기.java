import java.io.*;
import java.util.*;

// 맨 윗부분에서 연쇄되는 블럭들 기록
// 해당 블럭들 제거한 다음 단계 field를 생성해 백트래킹 진행
public class Solution {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int N, W, H;
	private static int minBlocks;
	
	private static class FieldInfo{
		
		int blockNum;
		int[][] field;
		Set<Integer>[] chains;
		
		public FieldInfo(int[][] field, int blockNum) {
			this.blockNum = blockNum;
			this.field = field;
			this.chains = new Set[W];
			
			for (int lane = 0; lane < W; lane++) {
				chains[lane] = new HashSet<>();
				for (int top = 0; top < H; top++) {
					if (field[top][lane] > 0) {
						setChain(new boolean[H][W], lane, top, lane);
						break;
					}
				}
			}
		}
		
		public int getBlockNumber() {
			return blockNum;
		}
		
		public FieldInfo boom(int lane) {
			int[][] newField = new int[H][W];
			
			//eliminate blocks
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!chains[lane].contains(i * W + j)) {
						newField[i][j] = field[i][j];
					}
				}
			}
			
			//shift down for each columns (2 pointers)
			for (int j = 0; j < W; j++) {
				//zero: 빈 칸을 의미하는 인덱스
				int zero = H - 1;
				
				while (zero >= 0 && newField[zero][j] > 0) {
					zero--;
				}
				
				if (zero <= 0) {
					continue;
				}
				
				// zero 위에 숫자가 있으면 zero로 넣어줌
				for(int h = zero - 1; h >= 0; h--) {
					if (newField[h][j] > 0) {
						newField[zero--][j] = newField[h][j];
						newField[h][j] = 0;
					}
				}
			}
			return new FieldInfo(newField, blockNum - chains[lane].size());
		}
		
		private void setChain(boolean[][] visited, int lane, int i, int j) {
			int range = field[i][j];
			
			visited[i][j] = true;
			chains[lane].add(i * W + j);
			//사방 탐색
			for (int dir = 0; dir < 4; dir++) {
				//범위 확인
				for (int r = 1; r < range; r++) {
					int nextI = i + r * D[dir][0];
					int nextJ = j + r * D[dir][1];
					
					if (nextI < 0 || nextJ < 0 || nextI >= H || nextJ >= W) {
						break;
					}
					
					if (field[nextI][nextJ] == 0) {
						//좌우는 0 나와도 계속 탐색
						if (dir % 2 == 0) continue;
						//상하는 0나오면 다음 방향 탐색
						else break;
					}
					
					if (!visited[nextI][nextJ]) {
						setChain(visited, lane, nextI, nextJ);
					}
				}
				
			}
		}
		
	}
	
	private static void backtrack(FieldInfo fieldInfo, int depth) {
		if (depth == N) {
			minBlocks = Math.min(minBlocks, fieldInfo.getBlockNumber());
			return;
		}

		for (int lane = 0; lane < W; lane++) {
			backtrack(fieldInfo.boom(lane), depth + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			minBlocks = Integer.MAX_VALUE;
			int[][] field = new int[H][W];
			int blockNum = 0;
			
			//parse field
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
					if (field[i][j] > 0) {
						blockNum++;
					}
				}
			}

			backtrack(new FieldInfo(field, blockNum), 0);
			sb.append('#').append(tc).append(' ').append(minBlocks).append('\n');
		}
		System.out.print(sb);
	}

}