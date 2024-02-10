import java.io.*;
import java.util.*;

class Main {

    private static final int INF = 1_000_000;
    private static Map<Integer, Integer>[] adj;
    private static int[] dist;

    private static void dijkstra(int V, int K){
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
        BitSet check = new BitSet();

        dist[K] = 0;
        pq.add(K);
        for (int i = 0; !pq.isEmpty() && i < V - 1; i++) {
            //이미 선택된 노드는 패스
            while (!pq.isEmpty() && check.get(pq.element())){
                pq.remove();
            }
            if (pq.isEmpty()){
                return;
            }
            
            //선택 안된 노드중에서 가장 가까운 노드 선택
            int minNode = pq.remove();
            check.set(minNode);

            //선택한 노드의 주변 노드 거리 업데이트
            for (int node : adj[minNode].keySet()) {
                dist[node] = Math.min(dist[node], dist[minNode] + adj[minNode].get(node));
                pq.add(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()),
            E = Integer.parseInt(st.nextToken()),
            K = Integer.parseInt(br.readLine());

        //init dist
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        //init adj
        adj = new Map[V + 1];
        for (int i = 1; i <= V; i++){
            adj[i] = new HashMap<>();
        }

        //parse adj
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken());

            //가장 작은 간선으로 업데이트
            adj[a].put(b, Math.min(c, adj[a].getOrDefault(b, INF)));
        }

        dijkstra(V, K);

        //print
        for (int i = 1; i <= V; i++){
            sb.append(dist[i] < INF ? dist[i] : "INF").append('\n');
        }
        System.out.println(sb);
    }

}