import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<int[]> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tops = new int[N+1], ans = new int[N];

        for (int i = 1; i <= N; i++) tops[i] = Integer.parseInt(st.nextToken());
        //스택의 값은 지금까지의 값들 중 내림차순인 부분수열 (현재 원소보다 큰 값들만 있도록)
        for (int i = 1; i <= N; i++){
            while (!stack.isEmpty() && stack.peek()[1] < tops[i]) stack.pop();
            ans[i-1] = (stack.isEmpty() ? 0 : stack.peek()[0]);
            stack.push(new int[]{i, tops[i]});
        }
        for (int n : ans) bw.write(n+" ");
        bw.close();
    }
}