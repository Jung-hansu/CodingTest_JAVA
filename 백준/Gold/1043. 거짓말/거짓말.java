import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static void union(int a, int b){
        int x = find(a), y = find(b);
        parent[Math.max(x, y)] = Math.min(x, y);
    }
    private static int find(int n){
        if (parent[n] == n) return n;
        return find(parent[n]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), tmp, ans = 0;
        List<Integer> known = new ArrayList<>();
        List<Integer>[] pp = new ArrayList[M];

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        st = new StringTokenizer(br.readLine());
        tmp = Integer.parseInt(st.nextToken());
        while (tmp-- > 0) known.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++){
            pp[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                pp[i].add(Integer.parseInt(st.nextToken()));
                union(pp[i].get(0), pp[i].get(j));
            }
        }

    a:  for (int i = 0; i < M; i++) {
            for (int n : known)
                if (find(pp[i].get(0)) == find(n))
                    continue a;
            ans++;
        }
        System.out.println(ans);
    }
}
