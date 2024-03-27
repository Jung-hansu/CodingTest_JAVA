import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int N, M;
	private static char[][] miro;
	private static boolean[][][] visited;
	
	private static class Status{
		int i, j;
		int key;
		int level;
		boolean exit;
		
		public Status(int i, int j, int key, int level) {
			this.i = i;
			this.j = j;
			this.key = key;
			this.level = level;
		}
		
		public Status go(int[] d) {
			int nextI = i + d[0], nextJ = j + d[1];
			
			//맵을 벗어났거나 갔던 곳일 경우
			if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M || visited[key][nextI][nextJ]) {
				return null;
			}
			
			char curPos = miro[nextI][nextJ];
			
			//벽이거나 열쇠가 없는 문인 경우
			if (isWall(curPos) || isDoor(curPos) && !canOpen(curPos)) {
				return null;
			}
			
			Status next = new Status(nextI, nextJ, key, level);
			//열쇠인 경우
			if (isKey(curPos)) {
				next.setKey(curPos);
			}
			//출구인 경우
			if (isGate(curPos)) {
				next.setExit();
			}
			visited[next.key][next.i][next.j] = true;
			return next;
		}
		
		private boolean isWall(char c) {
			return c == '#';
		}
		
		private boolean isKey(char c) {
			return c >= 'a' && c <= 'f';
		}
		
		private boolean isDoor(char c) {
			return c >= 'A' && c <= 'F';
		}
		
		private boolean isGate(char c) {
			return c == '1';
		}
		
		private void setKey(char key) {
			this.key |= (1 << key - 'a');
			this.level++;
		}
		
		private void setExit() {
			exit = true;
		}
		
		private boolean canOpen(char door) {
			return (key & (1 << door - 'A')) > 0;
		}
	}
	
	private static int bfs(int startI, int startJ) {
		Queue<Status> q = new ArrayDeque<>();
		int count = 0;
		visited = new boolean[0x40][N][M];
		
		q.add(new Status(startI, startJ, 0, 1));
		visited[0][startI][startJ] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			
			count++;
			while(size-- > 0) {
				Status cur = q.remove();
				for (int[] d : D) {
					Status next = cur.go(d);
					
					if (next == null) {
						continue;
					}
					if (next.exit) {
						return count;
					}
					q.add(next);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startI = 0, startJ = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new char[N][M];
		
		//parse miro
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = line.charAt(j);
				if (miro[i][j] == '0') {
					startI = i;
					startJ = j;
				}
			}
		}
		
		System.out.println(bfs(startI, startJ));
	}
	
}