import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        public long min, max;
        public Node(long min, long max){
            this.min = min;
            this.max = max;
        }
    }
    private static class SegmentTree {
        private Node[] tree;
        public SegmentTree(long[] arr) {
            int tmp = Integer.highestOneBit(arr.length);
            tree = new Node[tmp << (tmp == arr.length ? 1 : 2)];
            init(arr, 1, 0, arr.length - 1);
        }

        public Node init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = new Node(arr[start], arr[start]);
            Node n1 = init(arr, 2 * node, start, (start + end) / 2);
            Node n2 = init(arr, 2 * node + 1, (start + end) / 2 + 1, end);
            return tree[node] = new Node(Math.min(n1.min, n2.min), Math.max(n1.max, n2.max));
        }
        public long min(int node, int start, int end, int from, int to) {
            if (from > end || to < start) return Integer.MAX_VALUE;
            if (from <= start && to >= end) return tree[node].min;
            return Math.min(min(2 * node, start, (start + end) / 2, from, to),
                    min(2 * node + 1, (start + end) / 2 + 1, end, from, to));
        }
        public long max(int node, int start, int end, int from, int to) {
            if (from > end || to < start) return 0;
            if (from <= start && to >= end) return tree[node].max;
            return Math.max(max(2 * node, start, (start + end) / 2, from, to),
                    max(2 * node + 1, (start + end) / 2 + 1, end, from, to));
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
            bw.write(segTree.min(1, 0, N-1, a-1, b-1)+" "+segTree.max(1, 0, N-1, a-1, b-1)+"\n");
        }
        bw.close();
    }
}
