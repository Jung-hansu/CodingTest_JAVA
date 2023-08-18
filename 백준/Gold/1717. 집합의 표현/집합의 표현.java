import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.min(x, y)] = Math.max(x, y);
    }
    private static int find(int n){
        if (parent[n] == n) return n;
        return find(parent[n]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken()),
                a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken());
            if (inst == 0) union(a, b);
            else bw.write(find(a) == find(b) ? "yes\n" : "no\n");
        }
        bw.close();
    }
}
