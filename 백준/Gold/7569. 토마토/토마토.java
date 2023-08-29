import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        int M = Integer.parseInt(st.nextToken()),
            N = Integer.parseInt(st.nextToken()),
            H = Integer.parseInt(st.nextToken()),
            unripe = 0, res = 0;
        int[][][] boxes = new int[H][N][M];

        for (int k = 0; k < H; k++)
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++)
                    if ((boxes[k][i][j] = Integer.parseInt(st.nextToken())) == 1) q.add(new int[]{k, i, j});
                    else if (boxes[k][i][j] == 0) unripe++;
            }

        while (!q.isEmpty() && unripe > 0){
            int size = q.size();
            while (size-- > 0){
                int[] tmp = q.remove();

                if (tmp[0] > 0 && boxes[tmp[0]-1][tmp[1]][tmp[2]] == 0){
                    q.add(new int[]{tmp[0]-1, tmp[1], tmp[2]});
                    boxes[tmp[0]-1][tmp[1]][tmp[2]] = 1;
                    unripe--;}
                if (tmp[0] < H-1 && boxes[tmp[0]+1][tmp[1]][tmp[2]] == 0){
                    q.add(new int[]{tmp[0]+1, tmp[1], tmp[2]});
                    boxes[tmp[0]+1][tmp[1]][tmp[2]] = 1;
                    unripe--;}
                if (tmp[1] > 0 && boxes[tmp[0]][tmp[1]-1][tmp[2]] == 0){
                    q.add(new int[]{tmp[0], tmp[1]-1, tmp[2]});
                    boxes[tmp[0]][tmp[1]-1][tmp[2]] = 1;
                    unripe--;}
                if (tmp[1] < N-1 && boxes[tmp[0]][tmp[1]+1][tmp[2]] == 0){
                    q.add(new int[]{tmp[0], tmp[1]+1, tmp[2]});
                    boxes[tmp[0]][tmp[1]+1][tmp[2]] = 1;
                    unripe--;}
                if (tmp[2] > 0 && boxes[tmp[0]][tmp[1]][tmp[2]-1] == 0){
                    q.add(new int[]{tmp[0], tmp[1], tmp[2]-1});
                    boxes[tmp[0]][tmp[1]][tmp[2]-1] = 1;
                    unripe--;}
                if (tmp[2] < M-1 && boxes[tmp[0]][tmp[1]][tmp[2]+1] == 0){
                    q.add(new int[]{tmp[0], tmp[1], tmp[2]+1});
                    boxes[tmp[0]][tmp[1]][tmp[2]+1] = 1;
                    unripe--;}
            }
            res++;
        }
        System.out.println(unripe > 0 ? -1 : res);
    }
}