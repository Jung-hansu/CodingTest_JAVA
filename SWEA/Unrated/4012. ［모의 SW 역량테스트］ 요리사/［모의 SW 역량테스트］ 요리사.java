import java.io.*;
import java.util.*;

public class Solution {

    private static BitSet comb = new BitSet();
    private static int N, minDiff;
    private static int[][] synergy;

    private static void combine(int depth, int num){
        if (depth >= N / 2) {
            int diff = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (!comb.get(i) ^ comb.get(j)) {
                        diff += (synergy[i][j] + synergy[j][i]) * (comb.get(i) ? 1 : -1);
                    }
                }
            }
            minDiff = Math.min(minDiff, Math.abs(diff));
            return;
        }

        for (int n = num; n <= N / 2 + depth; n++){
            comb.set(n);
            combine(depth + 1, n + 1);
            comb.clear(n);
        }
    }

    private static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        for (int tc = 1; tc <= T; tc++){
            N = readInt();
            synergy = new int[N][N];
            minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    synergy[i][j] = readInt();
                }
            }

            combine(0, 1);
            sb.append('#').append(tc).append(' ').append(minDiff).append('\n');
        }
        System.out.println(sb);
    }

}