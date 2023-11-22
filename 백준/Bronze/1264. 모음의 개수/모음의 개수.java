import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        while (!(s = br.readLine()).equals("#")){
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.toLowerCase().charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    cnt++;
            }
            bw.write(cnt+"\n");
        }
        bw.close();
    }
}
