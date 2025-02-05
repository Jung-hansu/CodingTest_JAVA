import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int cases = 0;

    private static void dfs(int[] kits, BitSet visited, int weight, int depth){
        if (weight < 0){
            return;
        }
        
        if (depth == N){
            cases++;
            return;
        }

        for (int i = 0; i < N; i++){
            if (!visited.get(i)){
                visited.set(i);
                dfs(kits, visited, weight + kits[i] - K, depth + 1);
                visited.clear(i);
            }
        }
    }

    private static int getCases(int[] kits){
        dfs(kits, new BitSet(), 0, 0);
        return cases;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] kits = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            kits[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getCases(kits));
    }

}