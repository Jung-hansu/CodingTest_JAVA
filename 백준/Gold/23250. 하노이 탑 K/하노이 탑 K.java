import java.io.*;
import java.util.*;

public class Main {
    private static void hanoi(long N, long K, int from, int via, int to) {
        if (K < (1L<<N-1)) hanoi(N-1, K, from, to, via);
        else if (K > (1L<<N-1)) hanoi(N-1, K - (1L<<N-1), via, from, to);
        else System.out.println(from+" "+to);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()), K = Long.parseLong(st.nextToken());

        hanoi(N, K, 1, 2, 3);
    }
}
