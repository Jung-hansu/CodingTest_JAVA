import java.io.*;
import java.util.*;

public class Main {
    private static String[] board;
    private static BitSet check = new BitSet();
    private static int max = 0;
    private static void dfs(int i, int j, int depth){
        max = Math.max(max, depth+1);
        if (i > 0 && !check.get(board[i-1].charAt(j)-'A')) {
            check.set(board[i-1].charAt(j)-'A');
            dfs(i - 1, j, depth + 1);
            check.clear(board[i-1].charAt(j)-'A');}
        if (j > 0 && !check.get(board[i].charAt(j-1)-'A')) {
            check.set(board[i].charAt(j-1)-'A');
            dfs(i, j - 1, depth + 1);
            check.clear(board[i].charAt(j-1)-'A');}
        if (i < board.length-1 && !check.get(board[i+1].charAt(j)-'A')) {
            check.set(board[i+1].charAt(j)-'A');
            dfs(i + 1, j, depth + 1);
            check.clear(board[i+1].charAt(j)-'A');}
        if (j < board[0].length()-1 && !check.get(board[i].charAt(j+1)-'A')) {
            check.set(board[i].charAt(j+1)-'A');
            dfs(i, j + 1, depth + 1);
            check.clear(board[i].charAt(j+1)-'A');}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        board = new String[R];

        for (int i = 0; i < R; i++) board[i] = br.readLine();
        check.set(board[0].charAt(0)-'A');
        dfs(0, 0, 0);
        System.out.println(max);
    }
}
