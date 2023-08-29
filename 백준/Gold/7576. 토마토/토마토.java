import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), unripe = 0, res = 0;
        int[][] box = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                if ((box[i][j] = Integer.parseInt(st.nextToken())) == 1) q.add(new int[]{i, j});
                else if (box[i][j] == 0) unripe++;
        }

        while (!q.isEmpty() && unripe > 0){
            int size = q.size();
            while (size-- > 0){
                int[] tmp = q.remove();

                if (tmp[0] > 0 && box[tmp[0]-1][tmp[1]] == 0){
                    q.add(new int[]{tmp[0]-1, tmp[1]});
                    box[tmp[0]-1][tmp[1]] = 1;
                    unripe--;}
                if (tmp[1] > 0 && box[tmp[0]][tmp[1]-1] == 0){
                    q.add(new int[]{tmp[0], tmp[1]-1});
                    box[tmp[0]][tmp[1]-1] = 1;
                    unripe--;}
                if (tmp[0] < N-1 && box[tmp[0]+1][tmp[1]] == 0){
                    q.add(new int[]{tmp[0]+1, tmp[1]});
                    box[tmp[0]+1][tmp[1]] = 1;
                    unripe--;}
                if (tmp[1] < M-1 && box[tmp[0]][tmp[1]+1] == 0){
                    q.add(new int[]{tmp[0], tmp[1]+1});
                    box[tmp[0]][tmp[1]+1] = 1;
                    unripe--;}
            }
            res++;
        }
        System.out.println(unripe > 0 ? -1 : res);
    }
}