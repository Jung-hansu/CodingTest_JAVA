import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static final int[][] HORSE = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
	private static int[][] field;
	private static int K, W, H;
	
	private static class Monkey{
		int i, j, jump;

		public Monkey(int i, int j, int jump) {
			this.i = i;
			this.j = j;
			this.jump = jump;
		}
	}

	private static int bfs() {
		Queue<Monkey> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[H][W]; //해당 칸에 갔을 때의 jump 수 기록
		int[][] jumped = new int[H][W];
		int move = 0;
		
		visited[0][0] = true;
		q.add(new Monkey(0, 0, K));
		while(!q.isEmpty()) {
			int size = q.size();

			move++;
			while(size-- > 0) {
				Monkey monkey = q.remove();
				
				//walk
				for (int[] dir : D) {
					int nextI = monkey.i + dir[0], nextJ = monkey.j + dir[1];
					
					if (nextI < 0 || nextJ < 0 || nextI >= H || nextJ >= W || field[nextI][nextJ] == 1) {
						continue;
					}
					if (visited[nextI][nextJ] && jumped[nextI][nextJ] >= monkey.jump) {
						continue;
					}

					if (nextI == H - 1 && nextJ == W - 1) {
						return move;
					}
					visited[nextI][nextJ] = true;
					jumped[nextI][nextJ] = monkey.jump;
					q.add(new Monkey(nextI, nextJ, monkey.jump));
				}
				
				if (monkey.jump == 0) {
					continue;
				}
				//jump
				for (int[] dir : HORSE) {
					int nextI = monkey.i + dir[0], nextJ = monkey.j + dir[1];
					
					if (nextI < 0 || nextJ < 0 || nextI >= H || nextJ >= W || field[nextI][nextJ] == 1) {
						continue;
					}
					if (visited[nextI][nextJ] && jumped[nextI][nextJ] >= monkey.jump - 1) {
						continue;
					}
					
					if (nextI == H - 1 && nextJ == W - 1) {
						return move;
					}
					visited[nextI][nextJ] = true;
					jumped[nextI][nextJ] = monkey.jump - 1;
					q.add(new Monkey(nextI, nextJ, monkey.jump - 1));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		if (W * H == 1) {
			System.out.println(0);
			return;
		}
		
		//parse field
		field = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
}