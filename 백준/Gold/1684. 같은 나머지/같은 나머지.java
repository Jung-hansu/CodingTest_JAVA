import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b){
        int x = Math.max(a,b), y = Math.min(a,b);
        if (x % y == 0) return y;
        return gcd(y, x%y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1){
            System.out.println(br.readLine());
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int[] arr = new int[N-1];

        for (int i = 0; i < N-1; i++) arr[i] = Math.abs(Integer.parseInt(st.nextToken())-first);
        int D = arr[0];
        for (int i = 1; i < N-1; i++) {
            if (arr[i] == 0) continue;
            D = (D == 0 ? arr[i] : Math.min(gcd(arr[i], D), D));
        }
        System.out.println(D>0 ? D : first);
    }
}
