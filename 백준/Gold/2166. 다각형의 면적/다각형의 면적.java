import java.io.*;
import java.util.*;

public class Main {
    private static double getArea(long[][] points){
        int N = points.length;
        double res = 0;
        for (int i = 0; i < points.length; i++)
            res += points[i][0]*points[(i+1)%N][1] - points[(i+1)%N][0]*points[i][1];
        return Math.abs(res)/2.0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] points = new long[N][];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
        }

        System.out.printf("%.1f%n", getArea(points));
    }
}
