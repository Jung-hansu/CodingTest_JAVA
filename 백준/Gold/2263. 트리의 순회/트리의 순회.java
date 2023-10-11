import java.io.*;
import java.util.*;

public class Main {
    private static int[] pre, in, post;
    private static int idx = 0;
    private static int getIdx(int[] arr, int k){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k)
                return i;
        return -1;
    }
    private static void getPre(int in_from, int in_to, int post_from, int post_to){
        if (in_from > in_to || post_from > post_to) return;

        int parent = post[post_to], in_parent = getIdx(in, parent), post_parent = post_to;
        pre[idx++] = parent;
        getPre(in_from, in_parent-1, post_from, in_parent-in_from+post_from-1);
        getPre(in_parent+1, in_to, in_parent-in_from+post_from, post_parent-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        pre = new int[N];
        in = new int[N];
        post = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) in[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) post[i] = Integer.parseInt(st.nextToken());

        getPre(0, N-1, 0, N-1);
        for (int n : pre) bw.write(n+" ");
        bw.newLine();
        bw.close();
    }
}
