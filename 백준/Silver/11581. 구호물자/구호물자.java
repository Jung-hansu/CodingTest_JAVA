import java.io.*;
import java.util.*;

public class Main {

    private static boolean hasCycle(Set<Integer>[] adj, BitSet visited, int N, int cur){
        if (visited.get(cur)){
            return true;
        }

        if (cur == N){
            return false;
        }

        visited.set(cur);
        for (int next : adj[cur]){
            if (hasCycle(adj, visited, N, next)){
                return true;
            }
        }
        visited.clear(cur);
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer>[] adj = new Set[N];

        for (int from = 1; from < N; from++){
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            adj[from] = new HashSet<>();
            while (M-- > 0){
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
            }
        }

        System.out.println(hasCycle(adj, new BitSet(), N, 1) ? "CYCLE" : "NO CYCLE");
    }

}