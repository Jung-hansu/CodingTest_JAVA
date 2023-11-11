import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.max(x, y)] = Math.min(x, y);
    }
    private static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), cnt = 0;

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        while (M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 2; i <= N; i++)
            if (find(i) == 1)
                cnt++;
        System.out.println(cnt);
    }
}
