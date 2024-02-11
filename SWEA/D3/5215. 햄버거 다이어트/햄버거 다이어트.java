import java.io.*;
import java.util.*;

public class Solution {

    private static int knapsack(int[][] foods, int N, int L){
        int[][] dp = new int[N + 1][L + 1];

        Arrays.sort(foods, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i <= N; i++){
            int curFlavor = foods[i][0],
                curCalorie = foods[i][1];

            for (int c = 1; c <= L; c++){
                if (c < curCalorie) {
                    dp[i][c] = dp[i - 1][c];
                }
                else{
                    dp[i][c] = Math.max(dp[i - 1][c], curFlavor + dp[i - 1][c - curCalorie]);
                }
            }
        }

        return dp[N][L];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
            int[][] foods = new int[N + 1][2];

            //parsing
            for (int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                int flavor = Integer.parseInt(st.nextToken()),
                    calorie = Integer.parseInt(st.nextToken());
                foods[i][0] = flavor;
                foods[i][1] = calorie;
            }

            sb.append('#').append(tc).append(' ').append(knapsack(foods, N, L)).append('\n');
        }
        System.out.println(sb);
    }

}