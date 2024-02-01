import java.io.*;
import java.math.BigInteger;

public class Main {
	
	private static int[] primeCandidates = {1, 3, 7, 9};
	
	private static void getStrangePrime(BufferedWriter bw, int N, String prime) throws IOException{
		if (prime.length() == N) {
			bw.write(prime);
			bw.newLine();
			return;
		}
		
		for (int n : primeCandidates) {
			if (new BigInteger(prime + n).isProbablePrime(5)) {
				getStrangePrime(bw, N, prime + n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] startPrime = {"2", "3", "5", "7"};
		int N = br.read() - '0';
		
		for (String prime : startPrime) {
			getStrangePrime(bw, N, prime);
		}
		bw.close();
	}
	
}