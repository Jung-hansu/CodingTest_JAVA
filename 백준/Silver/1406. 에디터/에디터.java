import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> left = new Stack<>(), right = new Stack<>();
        String s = br.readLine();
        int N = s.length(), M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) left.push(s.charAt(i));
        while (M-- > 0) {
            String inst = br.readLine();
            if (inst.charAt(0) == 'L' && !left.isEmpty()) right.push(left.pop());
            else if (inst.charAt(0) == 'D' && !right.isEmpty()) left.push(right.pop());
            else if (inst.charAt(0) == 'B' && !left.isEmpty()) left.pop();
            else if (inst.charAt(0) == 'P') left.push(inst.charAt(2));
        }
        for (char c : left) bw.write(c);
        while (!right.isEmpty()) bw.write(right.pop());
        bw.flush();
    }
}