import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), idx = 0, cnt = 0;
        String S = br.readLine(), P = "I"+"OI".repeat(N);

        while ((idx = S.indexOf(P, idx)) >= 0) {
            cnt++;
            idx++;
        }
        System.out.println(cnt);
    }
}
