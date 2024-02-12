import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static long[] visited;
    private static boolean isCycle;
    private static int N, M;
    private static char[][] board;
    private static int[][] dp;  //해당 좌표부터 끝까지의 최대 거리

    private static void dfs(int i, int j){
        visited[i] ^= 1L << j;

        //4방 탐색
        for (int[] d : D){
            //해당 방향의 다음 좌표
            int I = i + d[0] * (board[i][j] & 15);
            int J = j + d[1] * (board[i][j] & 15);

            //1. 다음 좌표가 맵 외부에 있는가? : 맵 탈출시 이 좌표에서부터의 최대 깊이는 1
            if (I < 0 || J < 0 || I >= N || J >= M || board[I][J] == 'H') {
                dp[i][j] = Math.max(dp[i][j], 1);
                continue;
            }

            //2. Cycle이 존재하는가? : 존재시 표시 후 재귀 탈출
            if ((visited[I] & (1L << J)) > 0){
                isCycle = true;
                return;
            }

            //3. 탐색한 적 없는 좌표인가? : 없을 때만 dfs 진행
            if (dp[I][J] == 0) {
                dfs(I, J);
                if (isCycle) {
                    return;
                }
            }

            //최대 깊이 업데이트
            dp[i][j] = Math.max(dp[i][j], dp[I][J] + 1);
        }

        visited[i] ^= 1L << j;
    }

    private static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException{
        N = readInt(); M = readInt();
        visited = new long[N];
        board = new char[N][M + 1];
        dp = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j <= M; j++) {
                board[i][j] = (char)System.in.read();
            }
        }

        dfs(0, 0);
        System.out.println(isCycle ? -1 : dp[0][0]);
    }

}