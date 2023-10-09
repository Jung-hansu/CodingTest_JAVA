import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, total, res = Integer.MAX_VALUE;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        total = arr[r++];
        while (l < N)
            if (total >= S) {
                res = Math.min(res, r - l);
                total -= arr[l++];
            }
            else if (r < N) total += arr[r++];
            else break;
        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
