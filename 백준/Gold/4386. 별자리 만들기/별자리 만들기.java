import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        double total = 0;
        double[][] stars = new double[N][2];
        double[][] dist = new double[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
            for (int j = 0; j < i; j++)
                dist[j][i] = dist[i][j] = Math.sqrt(Math.pow(stars[i][0]-stars[j][0], 2) + Math.pow(stars[i][1]-stars[j][1], 2));
        }

        set.add(0);
        while (set.size() < N){
            double min = Double.MAX_VALUE;
            int idx = 0;
            for (int i : set){
                for (int j = 1; j < N; j++)
                    if (!set.contains(j) && min > dist[j][i]){
                        idx = j;
                        min = dist[j][i];
                    }}
            total += min;
            set.add(idx);
        }
        System.out.printf("%.2f\n", total);
    }
}
