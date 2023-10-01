import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Integer> stack = new Stack<>();
    private static int[] arr;
    private static void dfs(int N, int M, int idx, int depth) throws IOException {
        if (depth == M){
            for (int n : stack) bw.write(n+" ");
            bw.newLine();
            return;
        }
        for (int i = idx; i < N; i++){
            stack.push(arr[i]);
            dfs(N, M, i, depth + 1);
            stack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(N, M, 0, 0);
        bw.close();
    }
}
