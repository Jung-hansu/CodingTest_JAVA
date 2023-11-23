import java.io.*;
import java.util.*;

public class Main {
    private static int[][] f = new int[2][2];
    private static int gcd(int a, int b){
        int x = Math.max(a, b), y = Math.min(a, b);

        if (x % y == 0) return y;
        return gcd(x%y, y);
    }
    private static int[] calcFractions(){
        int tmp;
        int[] res = new int[2];

        res[0] = f[0][0] * f[1][1] + f[1][0] * f[0][1];
        res[1] = f[0][1] * f[1][1];
        tmp = gcd(res[0], res[1]);
        res[0] /= tmp;
        res[1] /= tmp;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] res;
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            f[i][0] = Integer.parseInt(st.nextToken());
            f[i][1] = Integer.parseInt(st.nextToken());
        }

        res = calcFractions();
        System.out.printf(res[0]+" "+res[1]);
    }
}
