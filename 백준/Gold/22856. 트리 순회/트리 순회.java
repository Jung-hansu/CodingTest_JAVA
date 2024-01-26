import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), res = 2 * (N - 1);
        int[] rightC = new int[N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()),
                l = Integer.parseInt(st.nextToken()),
                r = Integer.parseInt(st.nextToken());
            rightC[p] = r;
        }
        for (int n = 1; rightC[n] > 0; n = rightC[n]) res--;
        System.out.println(res);
    }
}
