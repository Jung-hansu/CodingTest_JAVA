import java.io.*;
import java.util.*;

public class Main {
    private static long bfs(int N, int K){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        long res = 0;

        q.add(N); set.add(N);
        while (!q.isEmpty()){
            int size = q.size();
            res++;
            while (size-- > 0) {
                int tmp = q.remove();
                if (tmp+1 == K || tmp-1 == K || 2*tmp == K) return res;

                if (tmp < K && !set.contains(2*tmp)) {q.add(2 * tmp); set.add(2*tmp);}
                if (tmp < K && !set.contains(tmp+1)) {q.add(tmp + 1); set.add(tmp+1);}
                if (!set.contains(tmp-1)) {q.add(tmp - 1); set.add(tmp-1);}
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        System.out.println(N==K ? 0 : bfs(N, K));
    }
}