import java.io.*;
import java.util.*;

public class Main {

	private static int ACGT(char c) {
		return c == 'A' ? 0 : c == 'C' ? 1 : c == 'G' ? 2 : 3;
	}
	
	private static boolean isSafe(int[] condition, int[] counts) {
		for (int i = 0; i < 4; i++) {
			if (condition[i] > counts[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String dna = br.readLine();
		int[] condition = new int[4], counts = new int[4];
		int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		int l = 0, r = 0, res = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}
		
		while (r < P) {
			counts[ACGT(dna.charAt(r++))]++;
		}
		if (isSafe(condition, counts)) {
			res++;
		}
		
		while (r < S) {
			counts[ACGT(dna.charAt(r++))]++;
			counts[ACGT(dna.charAt(l++))]--;
			
			if (isSafe(condition, counts)) {
				res++;
			}
		}
		
		System.out.println(res);
	}
	
}