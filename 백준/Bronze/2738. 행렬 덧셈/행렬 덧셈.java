import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++)
                    arr[j][k] += Integer.parseInt(st.nextToken());
            }
        for (int[] a : arr) {
            for (int n : a)
                System.out.print(n+" ");
            System.out.println();
        }
    }
}
