import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;

		for (int tc = 1; (s = br.readLine()) != null; tc++) {
			List<Integer> codes = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(s);
			int M = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++)
				codes.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			while (M-- > 0) {
				String command = st.nextToken();
				int idx, cnt;
				
				switch(command) {
					case "I":
						idx = Integer.parseInt(st.nextToken());
						cnt = Integer.parseInt(st.nextToken());
						
						for (int i = 0; i < cnt; i++)
							codes.add(idx + i, Integer.parseInt(st.nextToken()));
						break;
					case "D":
						idx = Integer.parseInt(st.nextToken());
						cnt = Integer.parseInt(st.nextToken());
						
						for (int i = 0; i < cnt; i++)
							codes.remove(idx);
						break;
					default:
						cnt = Integer.parseInt(st.nextToken());
						
						for (int i = 0; i < cnt; i++)
							codes.add(Integer.parseInt(st.nextToken()));
				}
			}

			Iterator<Integer> it = codes.iterator();
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < 10; i++)
				sb.append(it.next()).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
	}
}