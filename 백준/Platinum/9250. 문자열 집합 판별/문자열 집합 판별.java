import java.io.*;

public class Main {
    private static class Node{
        Node[] child = new Node[26];
        boolean isTerminal;
    }
    private static class Trie{
        Node root = new Node();

        void insert(String s){
            Node node = root;
            for (int i = 0; i < s.length(); i++)
                if (node.child[s.charAt(i)-'a'] != null)
                    node = node.child[s.charAt(i)-'a'];
                else node = node.child[s.charAt(i)-'a'] = new Node();
            node.isTerminal = true;
        }
        boolean search(String s, int idx){
            Node node = root;
            for (int i = idx; i < s.length(); i++) {
                node = node.child[s.charAt(i)-'a'];
                if (node == null) return false;
                if (node.isTerminal) return true;
            }
            return false;
        }
        boolean contains(String s){
            for (int i = 0; i < s.length(); i++)
                if (root.child[s.charAt(i)-'a'] != null && search(s, i))
                    return true;
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) trie.insert(br.readLine());
        for (int i = Integer.parseInt(br.readLine()); i > 0; i--)
            bw.write(trie.contains(br.readLine()) ? "YES\n" : "NO\n");
        bw.close();
    }
}
