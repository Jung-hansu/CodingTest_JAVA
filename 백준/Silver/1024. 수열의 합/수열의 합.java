import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double N = Double.parseDouble(st.nextToken()), L = Double.parseDouble(st.nextToken());

		if (L == 2 && N%2 == 1) System.out.println((int)N/2 + " " + ((int)N/2+1));
		else{
			while ((N/L - (L-1)/2) >= 0 && (N/L - (L-1)/2) - (int)(N/L - (L-1)/2) > 0)
				L++;
			if (N/L - (L-1)/2 < 0 || L > 100)
				System.out.println(-1);
			else
				for (int i = 0, a = (int)(N/L - (L-1)/2); i < L; i++)
					System.out.print((i==0?"":" ") + (a+i));
		}
	}
}