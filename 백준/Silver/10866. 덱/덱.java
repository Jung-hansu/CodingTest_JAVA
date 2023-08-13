import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push_front"))
                deq.addFirst(Integer.parseInt(st.nextToken()));
            else if (s.equals("push_back"))
                deq.addLast(Integer.parseInt(st.nextToken()));
            else if (s.equals("pop_front"))
                bw.write(deq.isEmpty() ? "-1\n" : deq.removeFirst()+"\n");
            else if (s.equals("pop_back"))
                bw.write(deq.isEmpty() ? "-1\n" : deq.removeLast()+"\n");
            else if (s.equals("size"))
                bw.write(deq.size()+"\n");
            else if (s.equals("empty"))
                bw.write(deq.isEmpty() ? "1\n" : "0\n");
            else if (s.equals("front"))
                bw.write(deq.isEmpty() ? "-1\n" : deq.peekFirst()+"\n");
            else
                bw.write(deq.isEmpty() ? "-1\n" : deq.peekLast()+"\n");
        }
        bw.close();
    }
}