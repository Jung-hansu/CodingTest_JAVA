import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(br.readLine());
			List<String> codes = new ArrayList<>();
			
			// parse codes
			for (int i = 0; i < N; i++) {
				codes.add(st.nextToken());
			}
			
			// operation
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < op; i++) {
				st.nextToken(); // I
				
				int idx = Integer.parseInt(st.nextToken()), cnt = Integer.parseInt(st.nextToken());
				while (cnt-- > 0) {
					codes.add(idx++, st.nextToken());
				}
			}
			
			// print
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < 10; i++) {
				sb.append(codes.get(i)).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
}