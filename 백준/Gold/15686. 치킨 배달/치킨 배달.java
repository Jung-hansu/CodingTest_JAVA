import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static List<int[]> homes = new ArrayList<>();
	private static List<int[]> chickens = new ArrayList<>();
	private static List<int[]> combs = new ArrayList<>();
	private static int[][] field;
	private static int[] arr;
	private static int N, M;
	
	private static void getCombs(int num, int idx){
		if (idx == M) {
			combs.add(Arrays.copyOf(arr, M));
			return;
		}
		if (num == chickens.size()){
			return;
		}
		
		for (int i = num; i <= chickens.size() - M + idx; i++) {
			arr[idx] = i;
			getCombs(i + 1, idx + 1);
		}
	}
	
	private static int getDist(int[] home) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		int dist = 0;
		
		q.add(home);
		visited[home[0]][home[1]] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			
			dist++;
			while(size-- > 0) {
				int[] pos = q.remove();
				
				for (int[] dir : D) {
					int nextI = pos[0] + dir[0];
					int nextJ = pos[1] + dir[1];
					
					if (nextI < 1 || nextJ < 1 || nextI > N || nextJ > N) {
						continue;
					}
					
					if (field[nextI][nextJ] == 3) {
						return dist;
					}
					if (!visited[nextI][nextJ]) {
						visited[nextI][nextJ] = true;
						q.add(new int[] {nextI, nextJ});
					}
				}
			}
		}
		return -1;
	}
	
	private static int findChickenDist() {
		int minSum = Integer.MAX_VALUE;
		
		arr = new int[M];
		getCombs(0, 0);
		for (int[] comb : combs) {
			int sum = 0;
			
			for (int c : comb) {
				int[] tmp = chickens.get(c);
				field[tmp[0]][tmp[1]] = 3;
			}
			for (int[] home : homes) {
				sum += getDist(home);
			}
			for (int c : comb) {
				int[] tmp = chickens.get(c);
				field[tmp[0]][tmp[1]] = 2;
			}
			minSum = Math.min(minSum, sum);
		}
		
		return minSum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 1) {
					homes.add(new int[] {i, j});
				}
				if (field[i][j] == 2) {
					chickens.add(new int[] {i, j});
				}
				
			}
		}
		
		System.out.println(findChickenDist());
	}
	
}