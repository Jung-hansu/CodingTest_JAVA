import java.io.*;
import java.util.*;

public class Main {
    private static char[][] field;
    private static boolean isMovable(int i, int j){
        return i >= 0 && i < field.length && j >= 0 && j < field[0].length && field[i][j] != 'X';
    }
    private static int bfs(int[] sp){
        Queue<int[]> q = new LinkedList<>();
        int res = 0;

        q.add(sp);
        field[sp[0]][sp[1]] = 'X';
        while(!q.isEmpty()){
            int[] tmp = q.remove();

            if (isMovable(tmp[0]+1, tmp[1])){
                q.add(new int[]{tmp[0]+1, tmp[1]});
                if (field[tmp[0]+1][tmp[1]] == 'P') res++;
                field[tmp[0]+1][tmp[1]] = 'X';
            }
            if (isMovable(tmp[0], tmp[1]+1)){
                q.add(new int[]{tmp[0], tmp[1]+1});
                if (field[tmp[0]][tmp[1]+1] == 'P') res++;
                field[tmp[0]][tmp[1]+1] = 'X';
            }
            if (isMovable(tmp[0]-1, tmp[1])){
                q.add(new int[]{tmp[0]-1, tmp[1]});
                if (field[tmp[0]-1][tmp[1]] == 'P') res++;
                field[tmp[0]-1][tmp[1]] = 'X';
            }
            if (isMovable(tmp[0], tmp[1]-1)){
                q.add(new int[]{tmp[0], tmp[1]-1});
                if (field[tmp[0]][tmp[1]-1] == 'P') res++;
                field[tmp[0]][tmp[1]-1] = 'X';
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] sp = null;

        field = new char[N][M];
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                if ((field[i][j] = s.charAt(j)) == 'I')
                    sp = new int[]{i, j};
        }

        int res = bfs(sp);
        System.out.println(res > 0 ? res : "TT");
    }
}
