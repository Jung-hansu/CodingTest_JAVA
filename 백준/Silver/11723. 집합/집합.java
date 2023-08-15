import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()), set = 0;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("add")) set |= (1<<Integer.parseInt(st.nextToken()));
            else if (s.equals("remove")) set &= ~(1<<Integer.parseInt(st.nextToken()));
            else if (s.equals("check")) bw.write(set/(1<<Integer.parseInt(st.nextToken()))%2 + "\n");
            else if (s.equals("toggle")) set ^= (1<<Integer.parseInt(st.nextToken()));
            else if (s.equals("all")) set = (1<<21)-1;
            else set = 0;
        }
        bw.close();
    }
}