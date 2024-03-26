import java.io.*;
import java.util.*;

public class Main {

    private static class App{
        int memory, cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }

    private static int getMinCost(App[] apps, int M, int totalCost){
        int[] dp = new int[totalCost + 1];
        int minCost = 0;

        for (App app : apps){
            for (int i = totalCost; i >= app.cost; i--) {
                dp[i] = Math.max(dp[i], dp[i - app.cost] + app.memory);
            }
        }

        for (int i = 1; i <= totalCost; i++){
            if (dp[i] >= M){
                minCost = i;
                break;
            }
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st2.nextToken());
        int M = Integer.parseInt(st2.nextToken());
        int totalCost = 0;
        App[] apps = new App[N];

        //parse input
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int memory = Integer.parseInt(st1.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            totalCost += cost;
            apps[i] = new App(memory, cost);
        }

        System.out.println(getMinCost(apps, M, totalCost));
    }

}
