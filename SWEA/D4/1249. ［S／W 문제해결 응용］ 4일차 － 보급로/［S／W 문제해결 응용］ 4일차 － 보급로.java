import java.io.*;
import java.util.*;

public class Solution{

    private static class Node implements Comparable<Node>{
        int pos, cost;

        public Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int[][] field;
    private static int N;

    private static int dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        BitSet visited = new BitSet(N * N);

        pq.add(new Node(0,  0));
        while(!pq.isEmpty()){
            Node node;

            do {
                node = pq.remove();
            } while(visited.get(node.pos));
            visited.set(node.pos);

            if (node.pos == N * N - 1){
                return node.cost;
            }

            for (int[] d : D){
                int nextI = node.pos / N + d[0];
                int nextJ = node.pos % N + d[1];

                if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= N || visited.get(nextI * N + nextJ)){
                    continue;
                }

                pq.add(new Node(nextI * N + nextJ, node.cost + field[nextI][nextJ]));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());

            //parse field
            field = new int[N][N];
            for (int i = 0; i < N; i++){
                String line = br.readLine();
                for (int j = 0; j < N; j++){
                    field[i][j] = line.charAt(j) & 15;
                }
            }

            sb.append('#').append(tc).append(' ').append(dijkstra()).append('\n');
        }
        System.out.print(sb);
    }

}