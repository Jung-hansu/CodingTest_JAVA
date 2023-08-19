import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), idx = 0, res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) list.add(i);
        while (M-- > 0){
            int n = Integer.parseInt(st.nextToken()), tmp = list.indexOf(n);
            res += Math.min(Math.abs(tmp - idx), list.size() - Math.abs(tmp - idx));
            idx = tmp;
            list.remove(idx);
        }
        System.out.println(res);
    }
}
