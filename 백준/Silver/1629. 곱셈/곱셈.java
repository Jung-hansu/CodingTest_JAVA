import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken()),
             C = Long.parseLong(st.nextToken()), res = 1;

        for (; B > 0; B ^= Long.highestOneBit(B)){
            long prod = A % C;
            for (long tmp = B; tmp > 1; tmp >>= 1)
                prod = prod * prod % C;
            res = res * prod % C;
        }
        System.out.println(res);
    }
}