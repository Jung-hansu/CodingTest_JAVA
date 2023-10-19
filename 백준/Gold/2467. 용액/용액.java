import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), l = 0, r = N-1, Lres, Rres;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquids = new int[N];

        for (int i = 0; i < N; i++) liquids[i] = Integer.parseInt(st.nextToken());
        if ((long)liquids[l]*liquids[r] > 0) {
            if (liquids[l] < 0)  System.out.println(liquids[r - 1] + " " + liquids[r]);
            else System.out.println(liquids[l] + " " + liquids[l + 1]);
            return;
        }

        Lres = liquids[l];
        Rres = liquids[r];
        while (l < r){
            if (Math.abs(liquids[l] + liquids[r]) <= Math.abs(Lres + Rres)){
                Lres = liquids[l];
                Rres = liquids[r];
            }
            if (liquids[l] + liquids[r] > 0) r--;
            else if (liquids[l] + liquids[r] < 0) l++;
            else {
                System.out.println(liquids[l]+" "+liquids[r]);
                return;
            }
        }
        System.out.println(Lres+" "+Rres);
    }
}
