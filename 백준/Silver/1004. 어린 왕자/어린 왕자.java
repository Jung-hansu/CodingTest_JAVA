import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0){
			st = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(st.nextToken()), y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken()), y2 = Long.parseLong(st.nextToken());
			int n = Integer.parseInt(br.readLine()), res = 0;
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				long cx = Long.parseLong(st.nextToken()), cy = Long.parseLong(st.nextToken());
				long r = Long.parseLong(st.nextToken());
				if (((x1-cx)*(x1-cx)+(y1-cy)*(y1-cy) - r*r) * ((x2-cx)*(x2-cx)+(y2-cy)*(y2-cy) - r*r) < 0)
					res++;
			}
			bw.write(res + "\n");
		}
		bw.flush();
	}
}