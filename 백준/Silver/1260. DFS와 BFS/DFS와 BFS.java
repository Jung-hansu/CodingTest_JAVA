import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] adj;
    private static void dfs(boolean[] check, int V){
        check[V] = true;
        for (int v : adj[V])
            if (!check[v]){
                System.out.print(" "+v);
                dfs(check, v);
            }
    }
    private static void bfs(boolean[] check, int V){
        Queue<Integer> q = new LinkedList<>();

        q.add(V);
        check[V] = true;
        while (!q.isEmpty()){
            int tmp = q.remove();
            if (tmp != V) System.out.print(" "+tmp);
            for (int v : adj[tmp])
                if (!check[v]){
                    check[v] = true;
                    q.add(v);
                }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
            M = Integer.parseInt(st.nextToken()),
            V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        for (List<Integer> list : adj) list.sort(Comparator.naturalOrder());

        System.out.print(V);
        dfs(new boolean[N+1], V);

        System.out.print("\n"+V);
        bfs(new boolean[N+1], V);
    }
}