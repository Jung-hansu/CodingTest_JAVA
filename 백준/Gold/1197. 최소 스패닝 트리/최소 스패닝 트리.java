import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static class Edge{
        int A, B, C;
        Edge(int A, int B, int C){ this.A = A; this.B = B; this.C = C; }
    }
    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.max(x, y)] = Math.min(x, y);
    }
    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(o->o.C));
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), res = 0;

        parent = new int[V+1];
        for (int i = 0; i <= V; i++) parent[i] = i;
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                C = Integer.parseInt(st.nextToken());
            pq.add(new Edge(A, B, C));
        }
        for (int i = 0; i < V-1; i++){
            Edge e;
            do
                e = pq.remove();
            while (find(e.A) == find(e.B));
            union(e.A, e.B);
            res += e.C;
        }
        System.out.println(res);
    }
}
