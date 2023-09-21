import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        Node[] bit = new Node[2];
        boolean isTerminal;
    }
    private static class Trie{
        Node root = new Node();
        int maxLen, max = 0;
        Trie(int maxLen){this.maxLen = maxLen;}
        
        void insert(int n){
            Node node = root;
            String N = Integer.toBinaryString(n);
            for (int i = 0; i < maxLen - N.length(); i++)
                if (node.bit[0] == null) node = node.bit[0] = new Node();
                else node = node.bit[0];
            for (int i = 0; i < N.length(); i++)
                if (node.bit[N.charAt(i) - '0'] == null) node = node.bit[N.charAt(i) - '0'] = new Node();
                else node = node.bit[N.charAt(i) - '0'];
            node.isTerminal = true;
        }
        int getMaxXor(){
            getMax(root, root, 0, 0);
            return max;
        }
        private void getMax(Node node1, Node node2, int res, int depth){
            if (depth == maxLen){
                max = Math.max(max, res);
                return;
            }
            if (node1.bit[0] != null && node2.bit[1] != null)
                getMax(node1.bit[0], node2.bit[1], (res<<1)+1, depth+1);
            if (node1.bit[1] != null && node2.bit[0] != null)
                getMax(node1.bit[1], node2.bit[0], (res<<1)+1, depth+1);
            if (node1.bit[0] == null && node2.bit[0] == null)
                getMax(node1.bit[1], node2.bit[1], (res<<1), depth+1);
            if (node1.bit[1] == null && node2.bit[1] == null)
                getMax(node1.bit[0], node2.bit[0], (res<<1), depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Trie trie = new Trie(Integer.toBinaryString(max).length());
        for (int i = 0; i < N ;i++) trie.insert(arr[i]);
        System.out.println(trie.getMaxXor());
    }
}
