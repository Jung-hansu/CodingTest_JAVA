import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), res = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		//parsing
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i += (arr[i] == 0 ? 1 : 0)) {
			/* skip zeros */
			while (i < N && arr[i] == 0) i++;
			if (i == N) break;
			
			/* greedy counting */
			// ↘
			if (i < N - 1 && arr[i] > arr[i + 1]) {
				res += 3 * (arr[i] - arr[i + 1]);
				arr[i] = arr[i + 1];
			}
			else if (i < N - 2) {
				// →
				if (arr[i] == arr[i + 1]) {
					// → ↗ & → → 
					if (arr[i + 1] <= arr[i + 2]) {
						int tmp = arr[i];
						
						arr[i] = arr[i + 1] = 0;
						arr[i + 2] -= tmp;
						res += 7 * tmp;
					}
					// → ↘
					else {
						int tmp = arr[i] - arr[i + 2];
						
						arr[i] -= tmp;
						arr[i + 1] -= tmp;
						res += 5 * tmp;
					}
					
				}
				// ↗
				else {
					// ↗ ↗ & ↗ → 
					if (arr[i + 1] <= arr[i + 2]) {
						int tmp = arr[i];
						
						arr[i] = 0;
						arr[i + 1] -= tmp;
						arr[i + 2] -= tmp;
						res += 7 * tmp;
					}
					// ↗↗ ↘ (ex. 3 4 2)
					else if (arr[i] <= arr[i + 2]) {
						int tmp = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
						
						arr[i] -= tmp;
						arr[i + 1] -= tmp;
						res += 5 * tmp;
					}
					// ↗ ↘↘ (ex. 2 4 3)
					else {
						int tmp = arr[i] - arr[i + 2];
						
						arr[i] -= tmp;
						arr[i + 1] -= tmp;
						res += 5 * tmp;
					}
					
				}
			}
			// for last 2 elements
			else if (i == N - 2) {
				int tmp = arr[i];
				
				arr[i] = 0;
				arr[i + 1] -= tmp;
				res += 5 * tmp;
			}
			// for last element
			else {
				res += 3 * arr[i];
				arr[i] = 0;
			}
			
		}
		
		System.out.println(res);
	}
	
}