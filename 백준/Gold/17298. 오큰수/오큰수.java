import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], ans = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = N-1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            ans[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }
        for (int n : ans) bw.write(n+" ");
        bw.close();
    }
}