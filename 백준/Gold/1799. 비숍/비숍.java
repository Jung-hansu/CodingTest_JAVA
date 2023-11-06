import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] board;
    private static List<int[]> black = new ArrayList<>(), white = new ArrayList<>();
    private static int maxBlackBishop = 0, maxWhiteBishop = 0;
    private static void putBlackBishop(int idx, int bishop){
        if (idx == black.size()){
            maxBlackBishop = Math.max(maxBlackBishop, bishop);
            return;
        }

        for (; idx < black.size(); idx++) {
            int[] p = black.get(idx);
            if (board[p[0]][p[1]] == 1)
                if (isValid(p[0], p[1])) {
                    board[p[0]][p[1]] = 2;
                    putBlackBishop(idx + 1, bishop + 1);
                    board[p[0]][p[1]] = 1;
                }
        }
    }
    private static void putWhiteBishop(int idx, int bishop){
        if (idx == white.size()){
            maxWhiteBishop = Math.max(maxWhiteBishop, bishop);
            return;
        }

        for (; idx < white.size(); idx++) {
            int[] p = white.get(idx);
            if (board[p[0]][p[1]] == 1)
                if (isValid(p[0], p[1])) {
                    board[p[0]][p[1]] = 2;
                    putWhiteBishop(idx + 1, bishop + 1);
                    board[p[0]][p[1]] = 1;
                }
        }
    }
    private static boolean isValid(int i, int j){
        // check up left
        for (int n = 1; i - n >= 0 && j - n >= 0; n++)
            if (board[i - n][j - n] == 2) return false;
        // check up right
        for (int n = 1; i - n >= 0 && j + n < N; n++)
            if (board[i - n][j + n] == 2) return false;
        // check down left
        for (int n = 1; i + n < N && j - n >= 0; n++)
            if (board[i + n][j - n] == 2) return false;
        // check down right
        for (int n = 1; i + n < N && j + n < N; n++)
            if (board[i + n][j + n] == 2) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                if ((board[i][j] = Integer.parseInt(st.nextToken())) == 1) {
                    if ((i + j) % 2 == 0) black.add(new int[]{i, j});
                    else white.add(new int[]{i, j});
                }
        }
        putBlackBishop(0, 0);
        putWhiteBishop(0, 0);
        System.out.println(maxBlackBishop + maxWhiteBishop);
    }
}
