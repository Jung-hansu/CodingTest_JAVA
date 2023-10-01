import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Integer> stack = new Stack<>();
    private static void dfs(int N, int M, int idx, int depth) throws IOException {
        if (depth == M){
            for (int n : stack) bw.write(n+" ");
            bw.newLine();
            return;
        }
        for (int i = idx+1; i <= N; i++) {
            stack.push(i);
            dfs(N, M, i, depth + 1);
            stack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        dfs(N, M, 0, 0);
        bw.close();
    }
}
