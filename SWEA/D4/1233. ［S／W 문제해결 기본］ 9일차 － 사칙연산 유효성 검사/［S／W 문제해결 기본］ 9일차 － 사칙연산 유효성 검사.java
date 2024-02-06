import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()), res = 1;
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				char c = st.nextToken().charAt(0);

				if(2 * i < N && (c >= '0' && c <= '9') ||
						2 * i >= N && (c < '0' || c > '9')) {
					res = 0;
				}
			}
			sb.append('#').append(tc).append(' ').append(res).append('\n');
		}
		System.out.println(sb);
	}
	
}