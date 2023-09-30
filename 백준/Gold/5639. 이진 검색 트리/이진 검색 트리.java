import java.io.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static class Node{
        int v;
        Node l, r;
        Node(int v){this.v = v;}
    }
    private static class Tree{
        Node root = null;
        void insert(int n){
            Node node = root;

            if (node == null) {
                root = new Node(n);
                return;}
            while (true){
                if (n < node.v)
                    if (node.l == null) {
                        node.l = new Node(n);
                        return;}
                    else node = node.l;
                else
                    if (node.r == null) {
                        node.r = new Node(n);
                        return;}
                    else node = node.r;}
        }
        void postorder(Node node) throws IOException{
            if (node == null) return;
            postorder(node.l);
            postorder(node.r);
            bw.write(node.v+"\n");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        String s;

        while ((s = br.readLine()) != null)
            tree.insert(Integer.parseInt(s));
        tree.postorder(tree.root);
        bw.close();
    }
}
