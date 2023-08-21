import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++)
                if (i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    tmp++;
            bw.write((tmp + 1) + " ");
        }
        bw.close();
    }
}