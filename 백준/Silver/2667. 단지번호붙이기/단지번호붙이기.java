import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> houses = new ArrayList<>();
    private static int[][] field;
    private static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int size = 0;

        field[i][j] = 0;
        q.add(new int[]{i, j});
        while (!q.isEmpty()){
            int[] tmp = q.remove();
            size++;

            if (tmp[0] > 0 && field[tmp[0]-1][tmp[1]] == 1){
                field[tmp[0]-1][tmp[1]] = 0;
                q.add(new int[]{tmp[0]-1, tmp[1]});
            }
            if (tmp[1] > 0 && field[tmp[0]][tmp[1]-1] == 1){
                field[tmp[0]][tmp[1]-1] = 0;
                q.add(new int[]{tmp[0], tmp[1]-1});
            }
            if (tmp[0] < field.length-1 && field[tmp[0]+1][tmp[1]] == 1){
                field[tmp[0]+1][tmp[1]] = 0;
                q.add(new int[]{tmp[0]+1, tmp[1]});
            }
            if (tmp[1] < field[0].length-1 && field[tmp[0]][tmp[1]+1] == 1){
                field[tmp[0]][tmp[1]+1] = 0;
                q.add(new int[]{tmp[0], tmp[1]+1});
            }
        }
        houses.add(size);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        field = new int[N][N];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                field[i][j] = s.charAt(j)-'0';
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (field[i][j] == 1)
                    bfs(i, j);
        houses.sort(Comparator.naturalOrder());
        bw.write(houses.size()+"\n");
        for (int n : houses) bw.write(n+"\n");
        bw.close();
    }
}