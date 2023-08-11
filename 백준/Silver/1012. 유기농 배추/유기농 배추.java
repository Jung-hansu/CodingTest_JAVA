import java.io.*;
import java.util.*;

public class Main {
    private static void bfs(int[][] field, int i, int j){
        field[i][j] = 0;
        if (i > 0 && field[i-1][j] == 1) bfs(field, i-1, j);
        if (j > 0 && field[i][j-1] == 1) bfs(field, i, j-1);
        if (i < field.length-1 && field[i+1][j] == 1) bfs(field, i+1, j);
        if (j < field[0].length-1 && field[i][j+1] == 1) bfs(field, i, j+1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken()),
                answer = 0;
            int[][] field = new int[N][M];

            while (K-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            for (int i = 0; i < field.length; i++)
                for (int j = 0; j < field[0].length; j++)
                    if (field[i][j] == 1){
                        bfs(field, i, j);
                        answer++;
                    }
            bw.write(answer+"\n");
        }
        bw.flush();
    }
}