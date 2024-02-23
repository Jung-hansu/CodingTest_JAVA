import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, d, k, c, maxKinds = 0;
	private static int[] sushis;
	private static int[] nums;
	
	private static int getNumOfKinds() {
		int s = 0, e = 0, kindCnt = 0;
		
		//initialize two pointers
		nums[c]++;
		kindCnt++;
		for (int i = 0; i < k; i++) {
			if (nums[sushis[e]]++ == 0) {
				kindCnt++;
			}
			e = (e + 1) % N;
		}

		//run
		maxKinds = kindCnt;
		for (int i = 0; i < N - 1; i++) {
			
			if (nums[sushis[e]]++ == 0) {
				kindCnt++;
			}
			
			if (--nums[sushis[s]] == 0) {
				kindCnt--;
			}
			
			s = (s + 1) % N;
			e = (e + 1) % N;
			maxKinds = Math.max(maxKinds, kindCnt);
		}
		
		return maxKinds;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		nums = new int[d + 1];
		sushis = new int[N];
		for (int i = 0; i < N; i++) {
			sushis[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(getNumOfKinds());
	}
	
}