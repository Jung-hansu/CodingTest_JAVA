import java.io.*;
import java.math.BigInteger;

public class Main {
	
	private static void getStrangePrime(BufferedWriter bw, int N, String num) throws IOException{
		if (num.length() == N) {
			bw.write(num);
			bw.newLine();
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (new BigInteger(num + i).isProbablePrime(10))
				getStrangePrime(bw, N, num + i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = br.read() - '0';
		
		getStrangePrime(bw, N, "");
		bw.close();
	}
	
}