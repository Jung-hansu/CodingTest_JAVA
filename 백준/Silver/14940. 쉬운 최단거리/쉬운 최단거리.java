import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static void getDist(int[] sp){
        Queue<int[]> q = new LinkedList<>();

        q.add(sp);
        visited[sp[0]][sp[1]] = true;
        for (int dist = 0; !q.isEmpty(); dist++){
            for (int i = q.size(); i > 0; i--) {
                int[] pos = q.remove();

                map[pos[0]][pos[1]] = dist;
                if (pos[0] > 0 && !visited[pos[0]-1][pos[1]]) {
                    q.add(new int[]{pos[0]-1, pos[1]});
                    visited[pos[0]-1][pos[1]] = true;
                }
                if (pos[1] > 0 && !visited[pos[0]][pos[1]-1]) {
                    q.add(new int[]{pos[0], pos[1]-1});
                    visited[pos[0]][pos[1]-1] = true;
                }
                if (pos[0] < map.length-1 && !visited[pos[0]+1][pos[1]]) {
                    q.add(new int[]{pos[0]+1, pos[1]});
                    visited[pos[0]+1][pos[1]] = true;
                }
                if (pos[1] < map[0].length-1 && !visited[pos[0]][pos[1]+1]) {
                    q.add(new int[]{pos[0], pos[1]+1});
                    visited[pos[0]][pos[1]+1] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] sp = {};

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                if ((map[i][j] = Integer.parseInt(st.nextToken())) == 2)
                    sp = new int[]{i, j};
                else if (map[i][j] == 0) visited[i][j] = true;
        }

        getDist(sp);
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(visited[i][j] ? map[i][j] : -1).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
