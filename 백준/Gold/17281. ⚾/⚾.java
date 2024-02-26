import java.io.*;
import java.util.*;

public class Main {
	
	private static int[][] innings;
	private static int[] comb;
	private static int maxScore;
	static {
		comb = new int[9];
		comb[3] = 0;
	}
	
	private static void play() {
		int score = 0, out = 0, field = 0, set = 0;
		
		for (int i = 0; set < innings.length; i = (i + 1) % 9) {
			int hit = innings[set][comb[i]];
			
			if (hit == 0) {
				if (++out == 3) {
					set++;
					out = 0;
					field = 0;
				}
				continue;
			}
			field = ++field << hit;
			score += Integer.bitCount(field & ~15);
			field &= 15;
		}
		maxScore = Math.max(maxScore, score);
	}
	
	private static void getCombs(int idx, int check) {
		if (idx == 9) {
			play();
			return;
		}
		
		for (int n = 1; n < 9; n++) {
			if ((check & (1 << n)) > 0) {
				continue;
			}
			
			comb[idx] = n;
			getCombs(idx + (idx == 2 ? 2 : 1), check | (1 << n));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		innings = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				innings[i][j] = st.nextToken().charAt(0) & 15;
			}
		}
		
		getCombs(0, 0);
		System.out.println(maxScore);
	}
	
}