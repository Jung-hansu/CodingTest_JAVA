import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()), num = 1;
        int[][] arr = new int[N][];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = new int[]{Integer.parseInt(st.nextToken()), i};
        Arrays.sort(arr, Comparator.comparing(o->o[0]));
        for (int i = 0; i < N; i++){
            if (i == 0 || arr[i][0] == arr[i-1][0]) num--;
            ans[arr[i][1]] = num;
            num++;
        }
        for (int n : ans) bw.write(n+" ");
        bw.close();
    }
}