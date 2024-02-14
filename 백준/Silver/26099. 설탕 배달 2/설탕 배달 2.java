import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine()), res = N / 5;
		
		if (N == 4 || N == 7) res = -1;
		else if (N % 5 == 1 || N % 5 == 3) res++;
		else if (N % 5 == 2 || N % 5 == 4) res += 2;
		System.out.println(res);
	}
	
}