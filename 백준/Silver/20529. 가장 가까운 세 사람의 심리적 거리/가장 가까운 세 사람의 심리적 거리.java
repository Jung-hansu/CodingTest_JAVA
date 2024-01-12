import java.io.*;
import java.util.*;

public class Main {
	private static int getDiff(String a, String b, String c) {
		return getDiff(a, b) + getDiff(a, c) + getDiff(b, c);
	}
	private static int getDiff(String a, String b) {
		int res = 0;
		
		for (int i = 0; i < 4; i++)
			res += (a.charAt(i)==b.charAt(i)?0:1);
		return res;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] mbti = new String[N];
			
			if (N > 32) {
				br.readLine();
				bw.write("0\n");
				continue;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) mbti[i] = st.nextToken();
			for (int i = 0; i < N - 2; i++)
				for (int j = i+1; j < N - 1; j++)
					for (int k = j+1; k < N; k++)
						min = Math.min(min,  getDiff(mbti[i], mbti[j], mbti[k]));
			bw.write(min+"\n");
		}
		bw.close();
	}
}