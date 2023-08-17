import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            List<Character> list = new LinkedList<>();
            String s = br.readLine();
            int idx = 0;
            for (int i = 0; i < s.length(); i++)
                switch(s.charAt(i)){
                    case '<': idx = Math.max(idx-1, 0); break;
                    case '>': idx = Math.min(idx+1, list.size()); break;
                    case '-': if (idx > 0) list.remove(--idx); break;
                    default : list.add(idx++, s.charAt(i));
                }
            for (char c : list) bw.write(c);
            bw.write("\n");
        }
        bw.close();

    }
}
