import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<int[]> list = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), cnt = 1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)list.add(new int[]{i, Integer.parseInt(st.nextToken())});
        a:  while (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++)
                    if (list.get(0)[1] < list.get(i)[1]) {
                        list.add(list.remove(0));
                        continue a;
                    }
                if (list.remove(0)[0] == M) bw.write(cnt+"\n");
                cnt++;
            }
        }
        bw.close();
    }
}