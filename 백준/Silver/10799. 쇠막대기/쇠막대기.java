import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] sticks = br.readLine().toCharArray();
		int res = 0, piled = 0;

		for (int i = 0; i < sticks.length; i++){
			if (sticks[i] == '(') piled++;
			else if (sticks[i] == ')' && sticks[i - 1] != '('){
				piled--;
				res++;
			}
			else{
				piled--;
				res += piled;
			}
		}
		System.out.println(res);
	}
}
