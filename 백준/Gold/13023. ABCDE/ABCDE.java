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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        //init adj
        adj = new List[N];
        parent = new int[N];
        for (int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
            parent[i] = i;
        }

        //parse adj
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
            union(a, b);
        }

        //각 그룹별 최소 차수 노드(리프 및 준리프) 선정
        Set<Integer> leaves = new HashSet<>();
        for (int i = 0; i < N; i++){
            leaves.add(find(i));
        }

        //각 그룹별로 리프(및 준리프)부터 DFS 실행
        for (int leaf : leaves) {
            if (dfs(new boolean[N], leaf, 0)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}