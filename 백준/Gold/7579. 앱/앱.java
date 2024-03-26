import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000_000;

    private static class App{
        int memory, cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }

    private static int getMinCost(App[] apps, int M){
        int[] dp = new int[M + 1];
        int sum = 0;

        Arrays.fill(dp, INF);
        for (App app : apps){
            sum += app.memory;
            for (int i = Math.min(sum, M); i > 0; i--){
                if (i <= app.memory)
                    dp[i] = Math.min(dp[i], app.cost);
                else
                    dp[i] = Math.min(dp[i], dp[i - app.memory] + app.cost);
            }
        }
        return dp[M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st2.nextToken());
        int M = Integer.parseInt(st2.nextToken());
        App[] apps = new App[N];

        //parse input
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int memory = Integer.parseInt(st1.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            apps[i] = new App(memory, cost);
        }

        System.out.println(getMinCost(apps, M));
    }

}