import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Integer> stack = new Stack<>();
    private static BitSet check = new BitSet();
    private static void bt(int[] arr, int M, int depth) throws IOException{
        if (depth == M){
            for (int n : stack) bw.write(n+" ");
            bw.newLine();
            return;
        }
        for (int i = 0; i < arr.length; i++)
            if (!check.get(i)){
                stack.push(arr[i]);
                check.set(i);
                bt(arr, M,depth+1);
                check.clear(i);
                int tmp = stack.pop();
                while (i < arr.length-1 && arr[i+1] == tmp) i++;
            }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        bt(arr, M, 0);
        bw.close();
    }
}
