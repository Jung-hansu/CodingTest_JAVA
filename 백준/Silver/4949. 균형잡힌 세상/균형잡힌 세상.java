import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

    a:  while (!(s = br.readLine()).equals(".")){
            Stack<Character> stack = new Stack<>();
            for (int i = 0; s.charAt(i) != '.'; i++){
                char c = s.charAt(i);
                if (c == '[' || c == '(') stack.push(c);
                else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
                else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if (c == ']' || c == ')'){
                    bw.write("no\n");
                    continue a;
                }
            }
            bw.write(stack.isEmpty() ? "yes\n" : "no\n");
        }
        bw.close();
    }
}