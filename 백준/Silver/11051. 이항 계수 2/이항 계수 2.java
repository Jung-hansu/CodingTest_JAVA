import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] paskal = new int[N+1][N+3];

        paskal[0][1] = 1;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= i+1; j++)
                paskal[i][j] = (paskal[i-1][j] + paskal[i-1][j-1]) % 10007;
        System.out.println(paskal[N][K+1]);
    }
}