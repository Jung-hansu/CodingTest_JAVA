import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] tops = new int[N];
        long res = 0;

        for (int i = 0; i < N; i++) tops[i] = Integer.parseInt(br.readLine());
        //스택의 값은 지금까지의 값들 중 내림차순인 부분수열 (현재 원소보다 큰 값들만 있도록)
        for (int i = 0; i < N; i++){
            while (!stack.isEmpty() && stack.peek() <= tops[i])
                stack.pop();
            res += stack.size();
            stack.push(tops[i]);
        }
        System.out.println(res);
    }
}