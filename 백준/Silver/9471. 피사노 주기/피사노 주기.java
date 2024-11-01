import java.io.*;
import java.util.*;

public class Main {

    private static final int[] fibonacci = new int[5_000_000];
    static {
        fibonacci[1] = fibonacci[2] = 1;
    }

    private static int k(int n){
        if (n == 2){
            return 3;
        }

        int i = 2;
        while (fibonacci[i] % n != 1 || fibonacci[i - 1] % n != 0){
            fibonacci[i + 1] = (fibonacci[i] + fibonacci[i - 1]) % n;
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int M = Integer.parseInt(st.nextToken());

            sb.append(tc).append(" ").append(k(M)).append("\n");
        }
        System.out.print(sb);
    }

}