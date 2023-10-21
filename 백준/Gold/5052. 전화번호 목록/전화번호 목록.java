import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<Character, Node> child = new HashMap<>();
        boolean EOW;
    }
    static class Trie {
        Node root = new Node();
        boolean consistency = true;

        void insert(String str){
            Node node = root;
            for(int i=0; i<str.length(); i++)
                if (node.EOW) consistency = false;
                else node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
            if (!node.child.isEmpty()) consistency = false;
            node.EOW = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            while (N-- > 0) trie.insert(br.readLine());
            bw.write(trie.consistency ? "YES\n" : "NO\n");
        }
        bw.close();
    }
}
