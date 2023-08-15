import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()), set = 0;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add" -> set |= (1 << Integer.parseInt(st.nextToken()));
                case "remove" -> set &= ~(1 << Integer.parseInt(st.nextToken()));
                case "check" -> bw.write(set / (1 << Integer.parseInt(st.nextToken())) % 2 + "\n");
                case "toggle" -> set ^= (1 << Integer.parseInt(st.nextToken()));
                case "all" -> set = (1 << 21) - 1;
                default -> set = 0;
            }
        }
        bw.close();
    }
}