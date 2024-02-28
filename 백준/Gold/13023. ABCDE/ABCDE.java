import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] adj;
    private static int[] parent;

    private static void union(int a, int b){
        int x = find(a), y = find(b);

        //차수가 적은 노드가 부모노드
        if (adj[x].size() < adj[y].size()){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }

    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean dfs(boolean[] visited, int n, int depth){
        if (depth == 4){
            return true;
        }

        visited[n] = true;
        for (int v : adj[n]){
            if (!visited[v] && dfs(visited, v, depth + 1)){
                return true;
            }
        }
        return visited[n] = false;
    }

    private static int readInt() throws IOException {
        int c, n = 0;
        
        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    
    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();

        //init adj
        adj = new List[N];
        parent = new int[N];
        for (int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
            parent[i] = i;
        }

        //parse adj
        for (int i = 0; i < M; i++){
            int a = readInt();
            int b = readInt();

            adj[a].add(b);
            adj[b].add(a);
            union(a, b);
        }

        //각 그룹별로 리프(및 준리프)부터 DFS 실행
        for (int i = 0; i < N; i++) {
            if (find(i) == i && dfs(new boolean[N], i, 0)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}