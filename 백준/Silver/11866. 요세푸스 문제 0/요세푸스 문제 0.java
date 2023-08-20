import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) list.add(i);
        bw.write("<");
        for (int i = K-1; !list.isEmpty(); i+=K-1) {
            if (i >= list.size()) i %= list.size();
            bw.write(list.remove(i) + (list.isEmpty() ? ">\n" : ", "));
        }
        bw.close();
    }
}