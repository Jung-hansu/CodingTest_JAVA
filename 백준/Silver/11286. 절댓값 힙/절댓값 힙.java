import java.io.*;
import java.util.*;
import static java.lang.Math.abs;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> abs(o1) == abs(o2) ? o1 - o2 : abs(o1) - abs(o2));
		
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if (num != 0) {
				pq.add(num);
			}
			else {
				sb.append(pq.isEmpty() ? 0 : pq.remove()).append('\n');
			}
		}
		System.out.println(sb);
	}
	
}