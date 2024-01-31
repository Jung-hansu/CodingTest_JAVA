import java.io.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] arr;
	
	private static void combination(int idx) {
		if (idx == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = arr[idx - 1] + 1; i <= N; i++) {
			arr[idx] = i;
			combination(idx + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		N = line.charAt(0) - '0';
		M = line.charAt(2) - '0';
		arr = new int[M + 1];
		
		combination(1);
		System.out.println(sb);
	}
	
}