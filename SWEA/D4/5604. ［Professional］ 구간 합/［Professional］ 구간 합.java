import java.io.*;
import java.util.*;

public class Solution {

    private static final int[] sigma = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45};
    private static final Map<Long, Long> cache = new HashMap<>();

    private static boolean isNines(long N){
        return N == 9 || N % 10 == 9 && isNines(N / 10);
    }

    private static long getDigit(long N){
        return N > 9 ? getDigit(N / 10) * 10 : 1;
    }

    private static long S(long N){
        if (cache.containsKey(N)){
            return cache.get(N);
        }
        if (N < 10){
            return N > 0 ? sigma[(int)N] : 0;
        }
        if (isNines(N)){
            return 45L * ((long)Math.log10(N + 1)) * getDigit(N);
        }

        long v = getDigit(N);
        long res = N / v * (N % v + 1) + S(N % v) + S(N - 1 - N % v);

        cache.put(N, res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            sb.append('#').append(tc).append(' ').append(- S(A-1) + S(B)).append('\n');
        }
        System.out.println(sb);
    }

}