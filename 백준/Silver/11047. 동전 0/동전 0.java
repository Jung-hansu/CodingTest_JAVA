import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), res = 0;
        int[] values = new int[N];

        for (int i = 0; i < N; i++) values[N-i-1] = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            while (values[i] <= K) {
                K -= values[i];
                res++;
            }
        System.out.println(res);
    }
}
