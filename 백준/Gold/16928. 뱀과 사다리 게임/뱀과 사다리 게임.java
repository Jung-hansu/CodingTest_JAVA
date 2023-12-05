import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        Map<Integer, Integer> ladders = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M + N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(board, 1000);
        q.add(new int[]{1, 0});
        board[1] = 0;
        while(!q.isEmpty()){
            int[] tmp = q.remove();

            for (int i = 1; i <= 6; i++)
                if (tmp[0] + i <= 100 && tmp[1] + 1 < board[tmp[0] + i]){
                    board[tmp[0] + i] = tmp[1] + 1;
                    if (tmp[0] + i < 100)
                        if (ladders.containsKey(tmp[0] + i)) {
                            if (tmp[1] + 1 < board[ladders.get(tmp[0] + i)])
                                q.add(new int[]{ladders.get(tmp[0] + i), tmp[1] + 1});}
                        else
                            q.add(new int[]{tmp[0] + i, tmp[1] + 1});
                }
        }
        System.out.println(board[100]);
    }
}
