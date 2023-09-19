import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int[][] D = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            Queue<int[]> q = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine()), cnt;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] from = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] to = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            
            if (from[0] == to[0] && from[1] == to[1]){
                bw.write("0\n");
                continue;
            }
            
            q.add(from);
            set.add(from[0]*N+from[1]);
        a:  for (cnt = 1; !q.isEmpty(); cnt++)
                for (int size = q.size(); size > 0; size--){
                    int[] tmp = q.remove();
                    for (int[] d : D){
                        int I = tmp[0]+d[0], J = tmp[1]+d[1];
                        if (I < 0 || J < 0 || I >= N || J >= N) continue;
                        if (I == to[0] && J == to[1]) break a;
                        if (!set.contains(I*N+J)) {
                            set.add(I*N+J);
                            q.add(new int[]{I, J});
                        }}}
            bw.write(cnt+"\n");
        }
        bw.close();
    }
}
