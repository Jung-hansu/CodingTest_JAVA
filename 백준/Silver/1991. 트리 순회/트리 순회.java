import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static class Node{
        public char name;
        public Node l, r;
        public Node(char name){ this.name = name; }
        public void setChild(Node l, Node r){ this.l = l; this.r = r; }
    }

    private static void preorder(Node root){
        if (root == null) return;
        sb.append(root.name);
        preorder(root.l);
        preorder(root.r);
    }
    private static void inorder(Node root){
        if (root == null) return;
        inorder(root.l);
        sb.append(root.name);
        inorder(root.r);
    }
    private static void postorder(Node root){
        if (root == null) return;
        postorder(root.l);
        postorder(root.r);
        sb.append(root.name);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Node> nodes = new HashMap<>();
        Node root = new Node('A');

        nodes.put('A', root);
        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node l = null, r = null;
            char M = st.nextToken().charAt(0), L = st.nextToken().charAt(0), R = st.nextToken().charAt(0);
            if (L != '.') nodes.put(L, l = new Node(L));
            if (R != '.') nodes.put(R, r = new Node(R));
            nodes.get(M).setChild(l, r);
        }
        preorder(root); sb.append('\n');
        inorder(root); sb.append('\n');
        postorder(root);
        System.out.println(sb);
    }
}
