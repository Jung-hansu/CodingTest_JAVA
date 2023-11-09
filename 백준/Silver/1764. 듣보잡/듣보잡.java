import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<String> names = new HashSet<>();
        Set<String> ans = new TreeSet<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) names.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (names.contains(name)) ans.add(name);
        }
        sb.append(ans.size()).append('\n');
        for (String s : ans) sb.append(s).append('\n');

        System.out.println(sb);
    }
}
