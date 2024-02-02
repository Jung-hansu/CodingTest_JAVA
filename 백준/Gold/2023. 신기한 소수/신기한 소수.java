import java.io.*;

public class Main {
	
	private static int[] primeCandidates = {1, 3, 7, 9};
	private static int N;
	
	private static boolean isPrime(int num) {
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void getStrangePrime(StringBuilder sb, int prime, int digit) {
		if (digit == N) {
			sb.append(prime).append('\n');
			return;
		}
		
		for (int n : primeCandidates) {
			if (isPrime(prime * 10 + n)) {
				getStrangePrime(sb, prime * 10 + n, digit + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] startPrime = {2, 3, 5, 7};
		
		N = br.read() - '0';
		for (int prime : startPrime) {
			getStrangePrime(sb, prime, 1);
		}
		System.out.println(sb);
	}
	
}