import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> draws = new PriorityQueue<>(Comparator.reverseOrder());
    private static int[][] paper;
    private static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int size = 0;

        paper[i][j] = 0;
        q.add(new int[]{i, j});
        while (!q.isEmpty()){
            int[] tmp = q.remove();
            size++;

            if (tmp[0] > 0 && paper[tmp[0]-1][tmp[1]] == 1){
                paper[tmp[0]-1][tmp[1]] = 0;
                q.add(new int[]{tmp[0]-1, tmp[1]});
            }
            if (tmp[1] > 0 && paper[tmp[0]][tmp[1]-1] == 1){
                paper[tmp[0]][tmp[1]-1] = 0;
                q.add(new int[]{tmp[0], tmp[1]-1});
            }
            if (tmp[0] < paper.length-1 && paper[tmp[0]+1][tmp[1]] == 1){
                paper[tmp[0]+1][tmp[1]] = 0;
                q.add(new int[]{tmp[0]+1, tmp[1]});
            }
            if (tmp[1] < paper[0].length-1 && paper[tmp[0]][tmp[1]+1] == 1){
                paper[tmp[0]][tmp[1]+1] = 0;
                q.add(new int[]{tmp[0], tmp[1]+1});
            }
        }
        draws.add(size);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        draws.add(0);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (paper[i][j] == 1)
                    bfs(i, j);
        System.out.println(draws.size()-1 + "\n" + draws.remove());
    }
}