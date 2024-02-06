import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long S = Long.parseLong(st.nextToken()), P = Long.parseLong(st.nextToken()); 
		
		if (S == P) {
			System.out.println(1);
			return;
		}
		if (S * S >= 4 * P) {
			System.out.println(2);
			return;
		}
		
		for (int res = 1; true; res++) {
			if (S <= res) {
				System.out.println(-1);
				return;
			}
			if (Math.pow((double)S / res, res) >= P) {
				System.out.println(res);
				return;
			}
		}
	}
	
}