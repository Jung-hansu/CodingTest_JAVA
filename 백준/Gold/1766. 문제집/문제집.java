import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) arr.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            inDegree[b]++;
        }
        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0)
                pq.add(i);

        while (!pq.isEmpty()) {
            int tmp = pq.remove();

            bw.write(tmp + " ");
            for (int next : arr.get(tmp)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    pq.add(next);
            }
        }
        bw.newLine();
        bw.close();
    }
}
