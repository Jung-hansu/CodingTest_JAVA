import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans;

        for (ans = 0; N > 0; ans++) N -= (ans>0 ? 6*ans : 1);
        System.out.println(ans);
    }
}