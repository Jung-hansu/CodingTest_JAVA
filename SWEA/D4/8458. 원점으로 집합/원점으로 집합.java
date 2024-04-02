import java.io.*;
import java.util.*;
/*
Let m be maxDist. Then,
	Σk = n(n+1)/2 ≧ m, n ∈ ℕ, both of n(n+1)/2 & m are even or odd.
	=> n² + n - 2m ≧ 0
	=> n ≧ (√(1 + 8m) - 1) / 2
	=> INF(n) = ⌈ (√(1 + 8m) - 1) / 2 ⌉
	∴ min(n) >= INF(n) s.t both of n(n+1)/2 & m are even or odd.  
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            long maxDist = 0, minMove = -1;
            long[] dists = new long[N];
            boolean isPossible = true;

            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                dists[i] = Math.abs(x) + Math.abs(y);
                maxDist = Math.max(maxDist, dists[i]);
                if (i > 0 && ((dists[i] ^ dists[i - 1]) & 1) == 1){
                	isPossible = false;
                }
            } 

            if (isPossible) {
	            int n = (int)Math.ceil((Math.sqrt(1 + 8 * maxDist) - 1) / 2);
	            
	            while (((n * (n + 1) / 2) & 1) != (maxDist & 1)){
	                n++;
	            }
	            minMove = n;
            }
            sb.append("#").append(tc).append(" ").append(minMove).append("\n");
        }
        System.out.println(sb);
    }

}