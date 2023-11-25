import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static class Vertex {
        int i, x, y, z;
        Vertex(int x, int y, int z, int i){
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    private static class Edge {
        int s, e, w;
        Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return false;
        parent[Math.max(a, b)] = Math.min(a, b);
        return true;
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Vertex[] vertices = new Vertex[N];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            vertices[i] = new Vertex(X, Y, Z, i);
        }

        Arrays.sort(vertices, Comparator.comparingInt(o -> o.x));
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(vertices[i-1].i, vertices[i].i, Math.abs(vertices[i].x- vertices[i-1].x)));
        }

        Arrays.sort(vertices, Comparator.comparingInt(o -> o.y));
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(vertices[i-1].i, vertices[i].i, Math.abs(vertices[i].y- vertices[i-1].y)));
        }

        Arrays.sort(vertices, Comparator.comparingInt(o -> o.z));
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(vertices[i-1].i, vertices[i].i, Math.abs(vertices[i].z- vertices[i-1].z)));
        }

        edges.sort(Comparator.comparingInt(o -> o.w));
        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;
        long result=0;

        for (Edge e : edges)
            if(union(e.s, e.e))
                result += e.w;
        System.out.println(result);
    }
}
