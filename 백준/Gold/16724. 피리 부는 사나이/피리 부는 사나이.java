import java.io.*;
import java.util.*;

public class Main {
    private static int[][] visited;
    private static int ans = 0;
    private static void setSafeZone(String[] map){
        int cycle_id = 1;
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length(); j++)
                if (visited[i][j] == 0)
                    findCycle(map, i, j, cycle_id++);
    }
    private static void findCycle(String[] map, int i, int j, int cycle_id){
        while (visited[i][j] == 0){
            visited[i][j] = cycle_id;
            if (map[i].charAt(j) == 'U') i--;
            else if (map[i].charAt(j) == 'D') i++;
            else if (map[i].charAt(j) == 'R') j++;
            else if (map[i].charAt(j) == 'L') j--;
        }
        if (visited[i][j] == cycle_id) ans++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] map = new String[N];

        visited = new int[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine();
        setSafeZone(map);
        System.out.println(ans);
    }
}
