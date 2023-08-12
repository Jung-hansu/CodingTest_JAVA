import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] A = new int[N][];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) A[i] = new int[]{Integer.parseInt(st.nextToken()), i};
        Arrays.sort(A, Comparator.comparingInt(o->o[0]));
        for (int i = 0; i < N; i++) P[A[i][1]] = i;
        for (int i = 0; i < N; i++) System.out.print(P[i]+ (i<N-1?" ":""));
    }
}