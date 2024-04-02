import java.io.*;
import java.math.BigInteger;

public class Main {
	
	//{A(n-1), A(n)}
	private static BigInteger[] arr = {BigInteger.ZERO, BigInteger.ONE};
	
	//arr => {A(2n-1), A(2n)}
	private static void getDoubleFibo() {
		BigInteger tmp1 = arr[0], tmp2 = arr[1];
		
		arr[0] = (tmp1.multiply(tmp1).add(tmp2.multiply(tmp2)));
		arr[1] = (BigInteger.valueOf(2).multiply(tmp1).multiply(tmp2).add(tmp2.multiply(tmp2)));
	}
	
	//arr => {A(n), A(n+1)}
	private static void getNextFibo() {
		BigInteger tmp1 = arr[0], tmp2 = arr[1];
		
		arr[0] = tmp2;
		arr[1] = tmp1.add(tmp2);
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