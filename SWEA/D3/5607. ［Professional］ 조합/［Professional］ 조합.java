import java.io.*;
import java.util.*;

public class Solution {
	
	private static final int P = 1_234_567_891;
	
	private static long pow(long N) {
		long res = 1;
		
		for (int exp = P - 2; exp > 0; exp >>= 1) {
			if ((exp & 1) == 1) {
				res = res * N % P;
			}
			N = N * N % P;
		}
		return res;
	}
	
	private static long combination(int N, int R) {
		long res = 1;
		
		for (int r = 1; r <= R; r++) {
			res = res * (N - r + 1) % P * pow(r) % P;
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			sb.append('#').append(tc).append(' ').append(combination(N, R)).append('\n');
		}
		System.out.print(sb);
	}

}