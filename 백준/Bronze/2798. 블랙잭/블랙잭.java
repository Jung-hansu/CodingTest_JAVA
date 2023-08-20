import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), res = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    a:  for (int i = 0; i < N-2; i++)
            for (int j = i + 1; j < N-1; j++)
                for (int k = j + 1; k < N; k++) {
                    int tmp = arr[i]+arr[j]+arr[k];
                    if (tmp <= M) res = Math.max(res, tmp);
                    if (tmp == M) break a;
                }
        System.out.println(res);
    }
}