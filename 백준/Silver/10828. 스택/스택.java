import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            else if (s.equals("pop"))
                bw.write(stack.isEmpty() ? "-1\n" : stack.pop()+"\n");
            else if (s.equals("size"))
                bw.write(stack.size()+"\n");
            else if (s.equals("empty"))
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            else
                bw.write(stack.isEmpty() ? "-1\n" : stack.peek()+"\n");
        }
        bw.close();
    }
}