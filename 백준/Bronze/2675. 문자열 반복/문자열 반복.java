import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rpt = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (int i = 0; i < s.length(); i++)
                for (int j = 0; j < rpt; j++)
                    bw.write(s.charAt(i));
            bw.write("\n");
        }
        bw.flush();
    }
}