import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        List<Integer>[] nextNode = new List[N + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++)nextNode[i] = new ArrayList<>();
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K - 1; j++) {
                int B = Integer.parseInt(st.nextToken());
                nextNode[A].add(B);
                inDegree[B]++;
                A = B;
            }
        }

        for (int i = 1; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                q.add(i);
        while(!q.isEmpty()){
            int tmp = q.remove();
            sb.append(tmp).append("\n");
            for (int next : nextNode[tmp])
                if (--inDegree[next] == 0)
                    q.add(next);
        }
        if (sb.length() < 2 * N) System.out.println(0);
        else System.out.println(sb);
    }
}
