import java.io.*;
import java.util.*;

public class Main {
    private static long bfs(long A, long B){
        Queue<Long> q = new LinkedList<>();
        int cnt = 1;

        q.add(A);
        while (!q.isEmpty()){
            cnt++;
            for (int i = q.size(); i > 0; i--) {
                long tmp = q.remove();

                if (tmp * 2 == B || tmp * 10 + 1 == B) return cnt;
                if (tmp * 2 < B) q.add(tmp * 2);
                if (tmp * 10 + 1 < B) q.add(tmp * 10 + 1);
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());

        System.out.println(A==B ? 1 : bfs(A, B));
    }
}
