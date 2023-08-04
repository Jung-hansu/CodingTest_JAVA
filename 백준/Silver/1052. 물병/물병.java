import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int newBottle = 0;
		
		while (Integer.bitCount(N) > K) {
			int tmp = Integer.lowestOneBit(N);
			newBottle += tmp;
			N += tmp;
		}
		System.out.println(newBottle);
	}
}