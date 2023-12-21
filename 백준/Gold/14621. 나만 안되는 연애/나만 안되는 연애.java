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
    private static int kruskal(List<int[]> adj, int N){
        int res = 0, loop = 0;

        adj.sort(Comparator.comparingInt(o->o[2]));
        for (int[] edge : adj)
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                res += edge[2];
                if (++loop == N - 1) return res;
            }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> adj = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[] univ = new boolean[N];

        //init parent
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        //parse input only for M-W paths
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) univ[i] = st.nextToken().equals("M");
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken()) - 1,
                u2 = Integer.parseInt(st.nextToken()) - 1,
                dist = Integer.parseInt(st.nextToken());
            if (univ[u1] ^ univ[u2]) adj.add(new int[]{u1, u2, dist});
        }

        System.out.println(kruskal(adj, N));
    }
}
