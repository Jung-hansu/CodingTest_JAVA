import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static BitSet check, inCycle;
    private static void findCycle(List<Integer> link, int x){
        int pos;

        if (check.get(arr[x])) {
            if ((pos = link.indexOf(arr[x])) >= 0)
                for (int i = pos; i < link.size(); i++)
                    inCycle.set(link.get(i));
            return;
        }
        check.set(arr[x]);
        link.add(arr[x]);
        findCycle(link, arr[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N + 1];
            check = new BitSet();
            inCycle = new BitSet();
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++)
                if (!check.get(i)){
                    List<Integer> link = new ArrayList<>();
                    check.set(i);
                    link.add(i);
                    findCycle(link, i);
                }
            bw.write(N-inCycle.cardinality()+"\n");
        }
        bw.close();
    }
}
