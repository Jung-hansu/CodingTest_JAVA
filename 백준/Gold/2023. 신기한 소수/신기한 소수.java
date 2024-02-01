import java.io.*;
import java.math.BigInteger;

public class Main {
	
	private static int[] primeCandidates = {1, 3, 7, 9};
	
	//이걸로 해보기
	private static boolean isPrime(int num) {
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		
		for (int i = 3; i <= (int)Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void getStrangePrime(StringBuilder sb, int N, int prime, int depth) {
		if (depth == N) {
			sb.append(prime).append('\n');
			return;
		}
		
		for (int n : primeCandidates) {
			if (isPrime(prime * 10 + n)) {
				getStrangePrime(sb, N, prime * 10 + n, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] startPrime = {2, 3, 5, 7};
		int N = br.read() - '0';
		
		for (int prime : startPrime) {
			getStrangePrime(sb, N, prime, 1);
		}
		System.out.println(sb);
	}
	
}