import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int idx = 0;

        while (idx < N && K > 0){
            char c = num.charAt(idx++);

            if (stack.isEmpty()){
                stack.addLast(c);
                continue;
            }

            while (K > 0 && !stack.isEmpty() && stack.peekLast() < c){
                stack.removeLast();
                K--;
            }

            stack.addLast(c);
        }

        for (char c : stack){
            sb.append(c);
        }
        sb.append(num.substring(idx));

        System.out.println(K == 0 ? sb : sb.substring(0, sb.length() - K));
    }

}