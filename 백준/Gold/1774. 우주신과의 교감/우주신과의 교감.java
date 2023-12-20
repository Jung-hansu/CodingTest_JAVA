import java.io.*;
import java.util.*;

public class Main {
    private static class Edge{
        int[] p1, p2;
        double distance;
        Edge(int[] p1, int[] p2){
            this.p1 = p1;
            this.p2 = p2;
            distance = distance(p1, p2);
        }
    }

    private static int[] parent;
    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.max(x, y)] = Math.min(x, y);
    }
    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static double distance(int[] p1, int[] p2){
        return Math.sqrt(((long)p1[0]-p2[0])*(p1[0]-p2[0])+((long)p1[1]-p2[1])*(p1[1]-p2[1]));
    }
    private static double dijkstra(List<Edge> edges, int N, int M){
        double res = 0;
        int loop = 0;

        edges.sort(Comparator.comparingDouble(o->o.distance));
        for (Edge e : edges)
            if (find(e.p1[2]) != find(e.p2[2])) {
                union(e.p1[2], e.p2[2]);
                res += e.distance;
                if (++loop == N - M) break;
            }
        return Math.round(res*100)/100.0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Edge> edges = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] coords = new int[N][];

        //parse points
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coords[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i};
        }
        //parse edges
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            union(a-1, b-1);
        }

        //add all edges
        for (int i = 0; i < N - 1; i++)
            for (int j = i; j < N; j++)
                edges.add(new Edge(coords[i], coords[j]));
        System.out.printf("%.2f\n",dijkstra(edges, N, M));
    }
}
