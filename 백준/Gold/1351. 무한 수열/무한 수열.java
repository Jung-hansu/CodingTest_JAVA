import java.io.*;
import java.util.*;

public class Main {
    private static Map<Long, Long> map = new HashMap<>();
    private static long getAn(long n, long p, long q){
        if (n == 0) return 1;
        if (!map.containsKey(n/p)) map.put(n/p, getAn(n/p, p, q));
        if (!map.containsKey(n/q)) map.put(n/q, getAn(n/q, p, q));
        return map.get(n/p) + map.get(n/q);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()), 
             P = Long.parseLong(st.nextToken()),
             Q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(getAn(N, P, Q));
    }
}