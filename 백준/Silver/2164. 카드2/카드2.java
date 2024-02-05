import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(Integer.bitCount(N) == 1 ? Integer.highestOneBit(N) : (N ^ Integer.highestOneBit(N)) << 1);
	}
	
}