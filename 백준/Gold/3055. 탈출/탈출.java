import java.io.*;
import java.util.*;

public class Main {
	
	private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static List<Integer> water = new ArrayList<>();
	private static int R, C;
	private static int startIdx, endIdx;
	private static char[][] forest;
	
	private static void bfs() {
		Queue<Integer> flood = new ArrayDeque<>(water);
		Queue<Integer> hedgehog = new ArrayDeque<>();
		int count = 0;
		
		hedgehog.add(startIdx);
		while(!flood.isEmpty() || !hedgehog.isEmpty()) {
			count++;
			
			//홍수 확장
			int floodSize = flood.size();
			while (floodSize-- > 0) {
				int curIdx = flood.remove();
				
				//사방탐색
				for (int[] d : D) {
					int nextI = curIdx / C + d[0];
					int nextJ = curIdx % C + d[1];
					char c;
					
					if (nextI < 0 || nextJ < 0 || nextI >= R || nextJ >= C ||
							(c = forest[nextI][nextJ]) == '*' || c == 'X' || c == 'D') {
						continue;
					}
					forest[nextI][nextJ] = '*';
					flood.add(nextI * C + nextJ);
				}
			}
			
			//고슴도치 이동
			int hedgehogSize = hedgehog.size();
			while (hedgehogSize-- > 0) {
				int curIdx = hedgehog.remove();
				
				//사방탐색
				for (int[] d : D) {
					int nextI = curIdx / C + d[0];
					int nextJ = curIdx % C + d[1];
					char c;
					
					if (nextI < 0 || nextJ < 0 || nextI >= R || nextJ >= C ||
							(c = forest[nextI][nextJ]) == '*' || c == 'X' || c == 'S') {
						continue;
					}
					
					if (c == 'D') {
						System.out.println(count);
						return;
					}
					forest[nextI][nextJ] = 'S';
					hedgehog.add(nextI * C + nextJ);
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//parse forest
		forest = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				
				forest[i][j] = line.charAt(j);
				if (forest[i][j] == 'S')
					startIdx = i * C + j; 
				else if (forest[i][j] == 'D')
					endIdx = i * C + j;
				else if (forest[i][j] == '*')
					water.add(i * C + j);
				
			}
		}
		
		bfs();
	}
	
}