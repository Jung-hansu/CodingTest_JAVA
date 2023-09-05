import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N==1) bw.write("*\n");
        else {
            bw.write(" ".repeat(N - 1) + "*\n");
            for (int i = 1; i < N - 1; i++) bw.write(" ".repeat(N - i - 1) + "*" + " ".repeat(2 * i - 1) + "*\n");
            bw.write("*".repeat(2 * N - 1) + "\n");
        }
        bw.close();
    }
}
