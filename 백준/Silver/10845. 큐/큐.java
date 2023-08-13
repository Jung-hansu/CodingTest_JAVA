import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push"))
                q.add(Integer.parseInt(st.nextToken()));
            else if (s.equals("pop"))
                bw.write(q.isEmpty() ? "-1\n" : q.remove(0)+"\n");
            else if (s.equals("size"))
                bw.write(q.size()+"\n");
            else if (s.equals("empty"))
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            else if (s.equals("front"))
                bw.write(q.isEmpty() ? "-1\n" : q.get(0)+"\n");
            else
                bw.write(q.isEmpty() ? "-1\n" : q.get(q.size()-1)+"\n");
        }
        bw.close();
    }
}