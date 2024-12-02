import java.io.*;
import java.util.*;

public class Main {

    private static int[] bfs(List<Integer>[] adj){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> tmp = new ArrayDeque<>();
        BitSet visited = new BitSet(adj.length);
        int dest, dist = -1, cnt;

        pq.add(1);
        visited.set(1);
        while (!pq.isEmpty()){
            int size = pq.size();

            dest = pq.element();
            dist++;
            cnt = size;
            while (size-- > 0){
                int cur = pq.remove();

                for (int next : adj[cur]){
                    if (!visited.get(next)){
                        visited.set(next);
                        tmp.add(next);
                        dest = Math.min(dest, next);
                    }
                }
            }

            if (tmp.isEmpty()){
                return new int[]{dest, dist, cnt};
            }

            while (!tmp.isEmpty()){
                pq.add(tmp.remove());
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new List[N + 1];

        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] result = bfs(adj);
        System.out.printf("%d %d %d\n", result[0], result[1], result[2]);
    }

}