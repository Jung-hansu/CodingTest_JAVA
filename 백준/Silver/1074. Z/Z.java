import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()),
			c = Integer.parseInt(st.nextToken()), res = 0;
		
		for (int n = 1 << N; n > 0; n /= 2) {
			if (r >= n / 2) {
				r -= n / 2;
				res += n * n / 2;
			}
			if (c >= n / 2) {
				c -= n / 2;
				res += n * n / 4;
			}
		}
		System.out.println(res);
	}
	
}