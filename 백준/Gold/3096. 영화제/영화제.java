import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 32;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long res = 0;
        int[][] bit = new int[N][(int)Math.ceil((double)N/SIZE)];

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            bit[a][b/SIZE] |= 1 << b%SIZE;
        }

        for (int i = 0; i < N-1; i++)
            for (int j = i+1; j < N; j++) {
                long cnt = 0;
                for (int k = 0; k < bit[0].length; k++)
                    cnt += Integer.bitCount(bit[i][k] & bit[j][k]);
                res += cnt * (cnt-1) / 2;
            }
        System.out.println(res);
    }
}
