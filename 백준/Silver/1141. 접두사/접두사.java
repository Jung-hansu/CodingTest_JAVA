import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<Character, Node> child = new HashMap<>();
    }
    static class Trie {
        Node root = new Node();
        int preX = 0;

        void insert(String str) {
            Node node = root;
            for(int i=0; i<str.length(); i++)
                node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
        }

        int getPreX(){
            dfs(root);
            return preX;
        }
        private void dfs(Node node){
            if (node.child.isEmpty()) preX++;
            for (Node n : node.child.values())
                dfs(n);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), l = 0, r = N-1, Lres, Rres, Mres;
        Trie trie = new Trie();

        for (int i = 0; i < N; i++)
            trie.insert(br.readLine());
        System.out.println(trie.getPreX());
    }
}
