import java.io.*;

class SegmentTree{

    static class Node {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public static Node min(Node n1, Node n2){
            if (n1 == null){
                return n2;
            }

            if (n2 == null){
                return n1;
            }

            if (n1.val == n2.val) {
                return n1.idx < n2.idx ? n1 : n2;
            }
            return n1.val < n2.val ? n1 : n2;
        }
    }

    private final Node[] tree;
    private final int leafLen, arrLen;

    public SegmentTree(int[] arr){
        arrLen = arr.length;
        leafLen = Integer.highestOneBit(arrLen) << 1;
        tree = new Node[leafLen << 1];
        init(arr, 1, 1, leafLen);
    }

    public int getMinIdx(int from, int to){
        return getMinIdx(1, from, to, 1, leafLen).idx;
    }

    public void update(int idx, int newVal){
        update(idx, newVal, 1, 1, leafLen);
    }

    private Node init(int[] arr, int node, int start, int end){
        if (start > arrLen){
            return null;
        }

        if (start == end){
            return tree[node] = new Node(start, arr[start - 1]);
        }

        Node left = init(arr, 2 * node, start, (start + end) / 2);
        Node right = init(arr, 2 * node + 1, (start + end) / 2 + 1, end);
        return tree[node] = Node.min(left, right);
    }

    private Node getMinIdx(int node, int from, int to, int start, int end){
        Node left = null, right = null;
        int mid = (start + end) / 2;

        if (start > to || end < from){
            return null;
        }

        if (start >= from && end <= to){
            return tree[node];
        }

        if (from <= mid){
            left = getMinIdx(node * 2, from, to, start, mid);
        }
        if (end >= mid + 1){
            right = getMinIdx(node * 2 + 1, from, to, mid + 1, end);
        }
        return Node.min(left, right);
    }

    private void update(int idx, int newVal, int node, int start, int end){
        if (start == end){
            tree[node].val = newVal;
            return;
        }

        if (idx <= (start + end) / 2) {
            update(idx, newVal, node * 2, start, (start + end) / 2);
        } else {
            update(idx, newVal, node * 2 + 1,(start + end) / 2 + 1, end);
        }
        tree[node] = Node.min(tree[node * 2], tree[node * 2 + 1]);
    }

}

public class Main {
    
    private static int readInt() throws IOException{
        int c, n = 0;
        
        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = readInt();
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        int M = readInt();
        for (int i = 0; i < M; i++){
            int a = readInt();
            int b = readInt();
            int c = readInt();

            if (a == 1){
                segmentTree.update(b, c);
            } else {
                sb.append(segmentTree.getMinIdx(b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

}