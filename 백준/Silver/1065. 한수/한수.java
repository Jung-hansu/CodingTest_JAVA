import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Math.min(Integer.parseInt(br.readLine()), 999);

		if (N >= 100){
			int ret = 0, tmp = N/100*100 + (N/100+1)/2*10 + N/100%2;
			if (N >= tmp) ret =  Math.min((N - tmp)/12+1, 5);
			System.out.println(99 + (N/100 - 1)*5 + ret);
		}
		else
			System.out.println(N);
	}
}