import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isTerminal;
    }

    private static class Trie{
        List<String> wordList = new ArrayList<>();
        Node root = new Node();
        int cnt = 0;

        void insert(String s){
            Node node = root;

            wordList.add(s);
            for (int i = 0; i < s.length(); i++)
                node = node.child.computeIfAbsent(s.charAt(i), k -> new Node());
            node.isTerminal = true;
        }
        String getAvgPress(){
            dfs(root, 0);
            return String.format("%.2f\n", Math.round(100f*cnt/wordList.size())/100f);
        }
        void dfs(Node node, int depth){
            if (node.isTerminal)
                cnt += depth;
            for (char c : node.child.keySet())
                dfs(node.child.get(c), node != root && node.child.size() == 1 && !node.isTerminal ? depth : depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        while ((s = br.readLine()) != null){
            Trie trie = new Trie();
            int N = Integer.parseInt(s);

            while (N-- > 0) trie.insert(br.readLine());
            bw.write(trie.getAvgPress());
        }
        bw.close();
    }
}
