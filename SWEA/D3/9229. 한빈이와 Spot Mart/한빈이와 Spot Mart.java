import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			int l = 0, r = N - 1, maxSum = 0;
			int[] snacks = new int[N];
			
			//parsing
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			//Two Pointer
			Arrays.sort(snacks);
			while (l < r) {
				int sum = snacks[l] + snacks[r];
				
				if (sum <= M) {
					maxSum = Math.max(maxSum, sum);
					l++;
				}
				else {
					r--;
				}
			}
			sb.append('#').append(tc).append(' ').append(maxSum > 0 ? maxSum : -1).append('\n');
		}
		System.out.println(sb);
	}
	
}