import java.io.*;
import java.util.*;

public class Main {
    //Trie 자료구조 인용
    private static Node root = new Node();
    private static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean EOW;
        String s;
    }
    private static void insert(String s){
        Node node = root;
        for (int i = 0; i < s.length(); i++)
            node = node.child.computeIfAbsent(s.charAt(i), k -> new Node());
        node.EOW = true;
        node.s = s;
    }

    //dfs를 돌면서 Trie 자료구조를 통해 단어 확인
    private static Map<String, Integer> ans = new HashMap<>();
    private static final int[][] D = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private static void dfs(char[][] field, Node node, int i, int j){
        if (node.EOW) ans.put(node.s, ans.get(node.s)+1);
        if (node.child.isEmpty()) return;

        for (int[] d : D){
            int I = (i+d[0]+field.length)%field.length, J = (j+d[1]+field[0].length)%field[0].length;
            if (node.child.containsKey(field[I][J]))
                dfs(field, node.child.get(field[I][J]), I, J);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
            M = Integer.parseInt(st.nextToken()),
            K = Integer.parseInt(st.nextToken());
        char[][] field = new char[N][M];

        //파싱
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                field[i][j] = s.charAt(j);
        }
        while(K-- > 0) {
            String s = br.readLine();
            ans.put(s, 0);
            insert(s);
        }

        //dfs
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (root.child.containsKey(field[i][j]))
                    dfs(field, root.child.get(field[i][j]), i, j);

        //출력
        for (int num : ans.values())
            bw.write(num+"\n");
        bw.close();
    }
}
