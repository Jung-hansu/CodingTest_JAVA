import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static Stack<Integer> stack = new Stack<>();
    private static void bt(int[] S, int i, int depth){
        if (depth == 6){
            for (int n : stack) sb.append(n).append(" ");
            sb.append('\n');
            return;
        }
        for (int k = i; k < S.length && k < i + S.length - 5; k++){
            stack.push(S[k]);
            bt(S, k+1, depth + 1);
            stack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] S = new int[K];

            if (K == 0) break;
            for (int i = 0; i < K; i++) S[i] = Integer.parseInt(st.nextToken());
            bt(S, 0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
