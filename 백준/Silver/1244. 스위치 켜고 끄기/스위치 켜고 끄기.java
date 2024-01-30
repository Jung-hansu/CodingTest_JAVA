import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), M;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switches = new int[N + 1];
		
		//parsing
		for (int i = 1; i <= N; i++)
			switches[i] = st.nextToken().charAt(0) - '0';

		//switch control
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int MW = Integer.parseInt(st.nextToken()), idx = Integer.parseInt(st.nextToken());
			
			if (MW == 1) {
				for (int n = idx; n <= N; n += idx)
					switches[n] ^= 1;
			}
			else {
				for (int n = 0; n < Math.min(idx, N - idx + 1) && switches[idx - n] == switches[idx + n]; n++)
					switches[idx - n] = switches[idx + n] ^= 1;
			}
		}
		
		for (int i = 1; i <= N; i++)
			sb.append(switches[i]).append(i % 20 > 0 ? ' ' : '\n');
		System.out.println(sb);
	}
	
}