import java.io.*;
import java.util.*;

public class Main {
    private static Map<Long, Long> map = new HashMap<>();
    private static long getAn(long n, long p, long q, long x, long y){
        if (n <= 0L) return 1L;
        if (!map.containsKey(n/p-x)) map.put(n/p-x, getAn(n/p-x, p, q, x, y));
        if (!map.containsKey(n/q-y)) map.put(n/q-y, getAn(n/q-y, p, q, x, y));
        return map.get(n/p-x) + map.get(n/q-y);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()),
             P = Long.parseLong(st.nextToken()),
             Q = Long.parseLong(st.nextToken()),
             X = Long.parseLong(st.nextToken()),
             Y = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(getAn(N, P, Q, X, Y));
    }
}