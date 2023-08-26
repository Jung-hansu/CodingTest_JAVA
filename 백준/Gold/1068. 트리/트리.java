import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] tree;
    private static BitSet check = new BitSet();
    private static void dfs(int del){
        check.flip(del);
        for (int n : tree[del]) dfs(n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int del = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node >= 0) tree[node].add(i);
        }
        dfs(del);
        for (int i = 0; i < N; i++)
            if (!check.get(i) && (tree[i].isEmpty() || tree[i].size() == 1 && tree[i].get(0) == del))
                ans++;
        System.out.println(ans);
    }
}