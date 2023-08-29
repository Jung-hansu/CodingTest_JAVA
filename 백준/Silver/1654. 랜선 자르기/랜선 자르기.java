import java.io.*;
import java.util.*;

public class Main {
    private static long binarySearch(long[] strings, long N, long max){
        long l = 0, r = max;

        while (l <= r){
            long total = 0, mid = (l+r)/2;
            if (mid == 0) mid = 1;
            for (long string : strings) total += string/mid;
            if (total >= N) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken()), N = Long.parseLong(st.nextToken()), max = 0;
        long[] strings = new long[(int)K];

        for(int i = 0; i < K; i++) {
            strings[i] = Long.parseLong(br.readLine());
            max = Math.max(max, strings[i]);
        }
        System.out.println(binarySearch(strings, N, max));
    }
}