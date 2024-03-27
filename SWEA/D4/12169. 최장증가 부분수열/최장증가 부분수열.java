import java.io.*;
import java.util.*;

public class Solution {
	
	private static int binarySearch(int[] arr, int top, int key) {
		int idx = Arrays.binarySearch(arr, 0, top, key);
		return idx < 0 ? - idx - 1 : idx;
	}
	
	private static int binaryLIS(int[] arr, int N) {
		int[] buf = new int[N];
		int maxLen = 0;
		
		for (int i = 0; i < N; i++) {
			int top = binarySearch(buf, maxLen, arr[i]);
			buf[top++] = arr[i];
			maxLen = Math.max(maxLen, top);
		}
		return maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//parse input
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append('#').append(tc).append(' ').append(binaryLIS(arr, N)).append('\n');
		}
		System.out.print(sb);
	}

}