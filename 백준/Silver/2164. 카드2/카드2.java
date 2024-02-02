import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] nums = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		q.addAll(Arrays.asList(nums));
		while (q.size() > 1) {
			q.remove();
			q.add(q.remove());
		}
		System.out.println(q.remove());
	}
	
}