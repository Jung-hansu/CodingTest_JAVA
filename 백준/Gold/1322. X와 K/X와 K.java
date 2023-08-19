import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken()), K = Long.parseLong(st.nextToken()), res = 0;

        for (int i = 0; K > 0; i++, X >>= 1)
            if (X % 2 == 0) {
                res |= ((K % 2) << i);
                K >>= 1;
            }
        System.out.println(res);
    }
}
