import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int n, m, start, end;
		int[] nums;
		String[] line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		nums = new int[n + 1];
		for (int i = 1; i < n + 1; i++) nums[i] = nums[i - 1] + Integer.parseInt(line[i - 1]);
		for (int i = 0; i < m; i++){
			line = br.readLine().split(" ");
			start = Integer.parseInt(line[0]);
			end = Integer.parseInt(line[1]);
			bw.write((nums[end] - nums[start - 1]) + "\n");
		}
		bw.flush();
	}
}