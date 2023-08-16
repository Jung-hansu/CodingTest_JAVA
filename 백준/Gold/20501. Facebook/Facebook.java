import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 60;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] bitAdj = new long[N][(int)Math.ceil((double)N/SIZE)];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                if (s.charAt(j)=='1') bitAdj[i][j/60] |= 1L << j%SIZE;
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken())-1, a2 = Integer.parseInt(st.nextToken())-1;
            long cnt = 0;
            for (int i = 0; i < bitAdj[0].length; i++)
                cnt += Long.bitCount(bitAdj[a1][i] & bitAdj[a2][i]);
            bw.write(cnt+"\n");
        }
        bw.close();
    }
}
