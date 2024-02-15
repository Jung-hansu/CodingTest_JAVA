import java.io.*;

public class Main {
	
	private static int readInt() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		int N = readInt(), r = readInt(), c = readInt(), res = 0;
		
		while (N-- > 0) {
			if (r >= (1 << N)) {
				r -= (1 << N);
				res += (1 << 2 * N + 1);
			}
			if (c >= (1 << N)) {
				c -= (1 << N);
				res += (1 << 2 * N);
			}
		}
		
		System.out.println(res);
	}
	
}