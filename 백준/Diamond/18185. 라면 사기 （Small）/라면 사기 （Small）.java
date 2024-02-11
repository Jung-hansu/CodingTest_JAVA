import java.io.*;
import java.util.*;

public class Main {
	
    private static int readInt() throws IOException {
        int c, res = 0;
        
        while ((c = System.in.read()) > 32)
            res = (res << 3) + (res << 1) + (c & 15);
        return res;
    }
    
	public static void main(String[] args) throws IOException {
		int N = readInt(), res = 0;
		int[] arr = new int[N];
		
		//parsing
		for (int i = 0; i < N; i++)
			arr[i] = readInt();

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