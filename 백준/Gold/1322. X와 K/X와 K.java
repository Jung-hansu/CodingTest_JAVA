import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        long res = 0;

        for (int i = 0; K > 0; i++){
            if ((X & 1) == 0) {
                res |= (K & 1L) << i;
                K >>= 1;
            }
            X >>= 1;
        }
        System.out.println(res);
    }

}