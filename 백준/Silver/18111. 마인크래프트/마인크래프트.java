import java.io.*;
import java.util.*;

public class Main {
    private static int flattenTime(int[][] field, int goal, int inventory){
        int toRemove = 0, toSet = 0;

        for (int[] row : field)
            for (int block : row)
                if (block < goal) toSet += goal - block;
                else toRemove += block - goal;
        if (inventory + toRemove < toSet) return -1;
        return 2 * toRemove + toSet;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()),
            maxH = 0, minH = Integer.MAX_VALUE, minTime = Integer.MAX_VALUE, minHeight = Integer.MAX_VALUE;
        int[][] field = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, field[i][j]);
                minH = Math.min(minH, field[i][j]);
            }
        }

        for (int height = maxH; height >= minH; height--) {
            int t = flattenTime(field, height, B);
            if (t >= 0 && minTime > t){
                minTime = t;
                minHeight = height;
            }
        }
        System.out.println(minTime+" "+minHeight);
    }
}
