import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 0; i <=N; i++) parent[i] = i;
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        System.out.println(Arrays.stream(parent)
                                 .map(Main::find)
                                 .boxed()
                                 .collect(Collectors.toSet())
                                 .size() - 1);
    }
}
