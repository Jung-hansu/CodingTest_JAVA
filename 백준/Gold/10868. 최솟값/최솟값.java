import java.io.*;
import java.util.*;

public class Main {
    private static class SegmentTree {
        private long[] tree;
        public SegmentTree(long[] arr) {
            int tmp = Integer.highestOneBit(arr.length);
            tree = new long[tmp << (tmp == arr.length ? 1 : 2)];
            init(arr, 1, 0, arr.length - 1);
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
            return tree[node] = Math.min(init(arr, 2 * node, start, (start + end) / 2),
                                        init(arr, 2 * node + 1, (start + end) / 2 + 1, end));
        }
        public long min(int node, int start, int end, int from, int to) {
            if (from > end || to < start) return Integer.MAX_VALUE;
            if (from <= start && to >= end) return tree[node];
            return Math.min(min(2 * node, start, (start + end) / 2, from, to),
                    min(2 * node + 1, (start + end) / 2 + 1, end, from, to));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        SegmentTree segTree = new SegmentTree(arr);
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            bw.write(segTree.min(1, 0, N-1, a-1, b-1)+"\n");
        }
        bw.close();
    }
}
