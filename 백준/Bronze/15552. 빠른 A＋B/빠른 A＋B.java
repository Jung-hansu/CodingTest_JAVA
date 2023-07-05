import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++){
			String[] line = br.readLine().split(" ");
			bw.write(Integer.parseInt(line[0]) + Integer.parseInt(line[1]) + "\n");
		}
		bw.flush();
	}
}