import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()), K = Long.parseLong(st.nextToken()), digit, nth, num;

        for (digit = 1; K >= 9 * (long)Math.pow(10, digit-1) * digit; digit++)
            K -= 9 * (long) Math.pow(10, digit - 1) * digit;
        if (K == 0){
            digit--;
            K += 9 * (long)Math.pow(10, digit - 1) * digit;
        }
        if (K == 0) digit--;
        nth = (K-1) % digit;
        K = (K-1)/ digit + 1;
        num = (long)Math.pow(10, digit - 1) + K - 1;
        System.out.println(N >= num ? String.valueOf(num).charAt((int)nth) : "-1");
    }
}
