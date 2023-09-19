import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static class Node{
        Map<Character, Node> child = new TreeMap<>();
        boolean isTerminal;
    }
    private static class Trie{
        final int[][] D = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Node root = new Node();
        TreeSet<String> words;
        boolean[][] check;

        void insert(String s){
            Node node = root;
            for (int i = 0; i < s.length(); i++)
                node = node.child.computeIfAbsent(s.charAt(i), k -> new Node());
            node.isTerminal = true;
        }

        void boggle(String[] board){
            String longest;
            int total = 0;

            words = new TreeSet<>((o1, o2)-> o1.length() == o2.length() ? o2.compareTo(o1) : o1.length() - o2.length());
            check = new boolean[4][4];
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    char c = board[i].charAt(j);
                    if (root.child.containsKey(c)) {
                        check[i][j] = true;
                        dfs(board, root.child.get(c), i, j, String.valueOf(c));
                        check[i][j] = false;
                    }
                }
            longest = words.last();
            for (String s : words){
                total += switch(s.length()){
                            case 1, 2 -> 0;
                            case 3, 4 -> 1;
                            case 5 -> 2;
                            case 6 -> 3;
                            case 7 -> 5;
                            default -> 11;};
            }
            sb.append(total).append(' ').append(longest).append(' ').append(words.size()).append('\n');
        }
        private void dfs(String[] board, Node node, int i, int j, String w){
            if (node.isTerminal) words.add(w);
            for (int[] d : D){
                Node tmp;
                int I = i+d[0], J = j+d[1];
                if (I < 0 || J < 0 || I > 3 || J > 3 || check[I][J] ||
                    (tmp = node.child.getOrDefault(board[I].charAt(J), null)) == null)
                    continue;
                check[I][J] = true;
                dfs(board, tmp, I, J, w + board[I].charAt(J));
                check[I][J] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();

        int w = Integer.parseInt(br.readLine());
        while (w-- > 0) trie.insert(br.readLine());
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        while (b-- > 0){
            String[] board = new String[4];
            for (int i = 0; i < 4; i++) board[i] = br.readLine();
            if (b > 0) br.readLine();
            trie.boggle(board);
        }
        System.out.print(sb);
    }
}
