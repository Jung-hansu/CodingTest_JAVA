import java.io.*;

public class Main {
    private static int cnt;
    private static void dfs(int N, int total){
        if (total == N){
            cnt++;
            return;
        }
        if (total + 1 <= N) dfs(N, total + 1);
        if (total + 2 <= N) dfs(N, total + 2);
        if (total + 3 <= N) dfs(N, total + 3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());

            cnt = 0;
            dfs(N, 0);
            bw.write(cnt+"\n");
        }
        bw.close();
    }
}
