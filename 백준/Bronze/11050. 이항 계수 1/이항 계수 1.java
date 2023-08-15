import java.io.*;
import java.util.*;

public class Main {
    private static int comb(int n, int k){
        if (n == k || k == 0) return 1;
        return comb(n-1, k-1) + comb(n-1, k);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        System.out.println(comb(N, K));
    }
}