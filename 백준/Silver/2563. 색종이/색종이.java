import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BitSet paper = new BitSet();
		int N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < 10; i++) {
				paper.set(100 * (x + i) + y, 100 * (x + i) + y + 10);
			}
		}
		System.out.println(paper.cardinality());
	}
	
}