import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		sb.append('<');
		while (q.size() > 1) {			
			for (int i = 0; i < M - 1; i++) {
				q.add(q.remove());
			}
			sb.append(q.remove()).append(", ");
		}
		
		System.out.println(sb.append(q.remove()).append('>'));
	}
	
}