import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        Map<String, Node> child = new TreeMap<>();
    }
    
    private static class Trie{
        Node root = new Node();

        void insert(String s){
            StringTokenizer st = new StringTokenizer(s);
            Node node = root;
            int len = Integer.parseInt(st.nextToken());
            for (int i = 0; i < len; i++)
                node = node.child.computeIfAbsent(st.nextToken(), k -> new Node());
        }
        void print(){
            StringBuilder sb = new StringBuilder();
            dfs(sb, root, 0);
            System.out.println(sb);
        }
        private void dfs(StringBuilder sb, Node node, int depth){
            for (String s : node.child.keySet()) {
                sb.append("--".repeat(depth)).append(s).append('\n');
                dfs(sb, node.child.get(s), depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) trie.insert(br.readLine());
        trie.print();
    }
}
