import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), min = Integer.MAX_VALUE;
        String[] board = new String[N];

        for (int i = 0; i < N; i++) board[i] = br.readLine();
        for (int h = 0; h < N-7; h++)
            for (int w = 0; w < M-7; w++) {
                int ans1 = 0, ans2 = 0;
                for (int i = h; i < h + 8; i++)
                    for (int j = w; j < w + 8; j++)
                        if (board[i].charAt(j) == ((i + j) % 2 == 0 ? 'B' : 'W')) ans1++;
                        else if (board[i].charAt(j) == ((i + j) % 2 == 0 ? 'W' : 'B')) ans2++;
                min = Math.min(min, Math.min(ans1, ans2));
            }
        System.out.println(min);
    }
}