import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("Case #")
                    .append(tc)
                    .append(": ")
                    .append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))
                    .append('\n');
        }
        System.out.println(sb);
    }
}
