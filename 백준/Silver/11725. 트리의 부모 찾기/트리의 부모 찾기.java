import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] adj = new ArrayList[N+1];
        BitSet bs = new BitSet(N+1);

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        q.add(1);
        bs.set(1);
        while (!q.isEmpty()){
            int tmp = q.remove();
            for (int n : adj[tmp])
                if (!bs.get(n)){
                    parent[n] = tmp;
                    bs.set(n);
                    q.add(n);
                }
        }

        for (int i = 2; i <= N; i++) bw.write(parent[i]+"\n");
        bw.close();
    }
}