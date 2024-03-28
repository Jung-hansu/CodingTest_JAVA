import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;

    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.max(x, y)] = Math.min(x, y);
    }

    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean canGo(int[] p1, int[] p2) {
        int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        return dist <= 1000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] coords = new int[N + 2][];

            //initialize parent
            parent = new int[N + 2];
            for (int i = 0; i < N + 2; i++){
                parent[i] = i;
            }

            //parse coordinates & union
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                coords[i] = new int[] {x, y};
                for (int j = i - 1; j >= 0; j--){
                    if (canGo(coords[i], coords[j])){
                        union(i, j);
                    }
                }
            }

            //run
            sb.append(find(0) == find(N + 1) ? "happy\n" : "sad\n");
        }
        System.out.print(sb);
    }

}