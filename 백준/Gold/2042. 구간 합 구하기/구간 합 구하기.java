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
            return tree[node] = init(arr, 2 * node, start, (start + end) / 2) +
                    init(arr, 2 * node + 1, (start + end) / 2 + 1, end);
        }
        public void update(long[] arr, int idx, long val){
            set(1, 0, arr.length-1, idx, val-arr[idx]);
            arr[idx] = val;
        }
        private void set(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return;
            tree[node] += diff;
            if (start != end) {
                set(2 * node, start, (start + end) / 2, idx, diff);
                set(2 * node + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }
        public long sum(int node, int start, int end, int from, int to) {
            if (from > end || to < start) return 0;
            if (from <= start && to >= end) return tree[node];
            return sum(2 * node, start, (start + end) / 2, from, to) +
                    sum(2 * node + 1, (start + end) / 2 + 1, end, from, to);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
            M = Integer.parseInt(st.nextToken()),
            K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
        SegmentTree segTree = new SegmentTree(arr);

        for (int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1)
                segTree.update(arr, b-1, c);
            else
                bw.write(segTree.sum(1, 0, N-1, b-1, (int)c-1)+"\n");
        }
        bw.close();
    }
}
