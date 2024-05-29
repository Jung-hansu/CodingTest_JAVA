import java.io.*;

public class Main {

    private static final int INF = 1_000_000_000;
    private static int[][] adj;

    private static void floydWarshall(){
        int N = adj.length - 1;
        for (int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    private static int readInt() throws IOException {
        int c, n = 0;
        
        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt(), M = readInt();

        adj = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++){
            for (int j = 0; j <= N; j++){
                adj[i][j] = (i == j ? 0 : INF);
            }
        }

        for (int i = 1; i < N; i++){
            int a = readInt(), b = readInt(), c = readInt();
            adj[a][b] = adj[b][a] = c;
        }

        floydWarshall();

        for (int i = 0; i < M; i++){
            int a = readInt(), b = readInt();
            sb.append(adj[a][b]).append('\n');
        }

        System.out.println(sb);
    }

}