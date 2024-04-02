import java.io.*;

public class Main {
	
	private static final int M = 1_000_000;
	private static long[] arr = {0, 1}; //{A(n-1), A(n)}
	
	//arr => {A(2n-1), A(2n)}
	private static void getDoubleFibo() {
		long tmp1 = arr[0], tmp2 = arr[1];
		
		arr[0] = (tmp1 * tmp1 % M + tmp2 * tmp2 % M) % M;
		arr[1] = (2 * tmp1 * tmp2 % M + tmp2 * tmp2 % M) % M;
	}
	
	//arr => {A(n), A(n+1)}
	private static void getNextFibo() {
		long tmp1 = arr[0], tmp2 = arr[1];
		
		arr[0] = tmp2;
		arr[1] = (tmp1 + tmp2) % M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		if (N <= 1) {
			System.out.println(N);
			return;
		}
		
		for (long b = Long.highestOneBit(N) >> 1; b > 0; b >>= 1) {
			getDoubleFibo();
			if ((N & b) > 0) {
				getNextFibo();
			}
		}

		System.out.println(arr[1]);
	}
	
}