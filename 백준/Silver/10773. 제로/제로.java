import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine()), sum = 0;

        while (N-- > 0){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) stack.pop();
            else stack.push(n);
        }
        for (int n : stack) sum += n;
        System.out.println(sum);
    }
}