import java.io.*;

public class Main {
    private static int[] board;
    private static int ans = 0;
    private static void nQueens(int col){
        if (col == board.length) {
            ans++;
            return;
        }
    a:  for (int i = 0; i < board.length; i++) {
            board[col] = i;
            for (int j = 0; j < col; j++)
                if (Math.abs(board[col] - board[j]) == Math.abs(col - j) || board[col] == board[j])
                    continue a;
            nQueens(col+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N];
        nQueens(0);
        System.out.println(ans);
    }
}
