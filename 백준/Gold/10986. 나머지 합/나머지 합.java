import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long res = 0;
        long[] arr = new long[N+1];

        map.put(0L, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + Long.parseLong(st.nextToken())) % M;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (long v : map.values()) res += v*(v-1)/2;
        System.out.println(res);
    }
}
