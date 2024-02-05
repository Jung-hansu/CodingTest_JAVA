import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		sb.append('<');
		for (int num = M - 1; list.size() > 1; num = (num + M - 1) % list.size()) {
			sb.append(list.remove(num)).append(", ");
		}
		System.out.println(sb.append(list.remove(0)).append('>'));
	}
	
}