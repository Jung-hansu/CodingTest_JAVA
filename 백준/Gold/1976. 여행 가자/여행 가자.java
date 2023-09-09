import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static void union(int i, int j){
        int x = find(i), y = find(j);
        parent[Math.max(x,y)] = Math.min(x,y);
    }
    private static int find(int a){
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++)
                if (st.nextToken().equals("1"))
                    union(i, j);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = find(Integer.parseInt(st.nextToken()));
        while(--M > 0)
            if (find(Integer.parseInt(st.nextToken())) != tmp){
                System.out.println("NO");
                return;
            }
        System.out.println("YES");
    }
}
