import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> adr = new HashMap<>();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            adr.put(st.nextToken(), st.nextToken());
        }
        while (M-- > 0) bw.write(adr.get(br.readLine())+"\n");
        bw.close();
    }
}