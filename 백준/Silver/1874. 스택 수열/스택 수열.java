import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine()), i = 1;

        while (N-- > 0){
            int n = Integer.parseInt(br.readLine());
            if (stack.isEmpty() || stack.peek() < n)
                while (i <= n) {
                    stack.push(i++);
                    list.add('+');
                }
            if (!stack.isEmpty() && stack.peek() == n){
                stack.pop();
                list.add('-');
            }
            else if (i > n && (stack.isEmpty() || stack.peek() != n)){
                System.out.println("NO");
                return;
            }
        }
        for (char c : list) System.out.println(c);
    }
}