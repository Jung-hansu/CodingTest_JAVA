import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String s = br.readLine(), bomb = br.readLine();

    a:  for (int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
            if (stack.size() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++)
                    if (stack.get(stack.size() - j - 1) != bomb.charAt(bomb.length() - j - 1))
                        continue a;
                for (int j = 0; j < bomb.length(); j++)
                    stack.pop();
            }
        }
        if (stack.isEmpty()) sb.append("FRULA");
        else
            for (char c : stack)
                sb.append(c);
        System.out.println(sb);
    }
}
