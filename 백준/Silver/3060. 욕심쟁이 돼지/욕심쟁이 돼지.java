import java.io.*;
import java.util.*;

public class Main {

    private static double log4(long n){
        return Math.log(n) / Math.log(4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int N = Integer.parseInt(br.readLine()), days = 1;
            long sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++){
                sum += Integer.parseInt(st.nextToken());
            }

            while (sum <= N){
                sum *= 4;
                days++;
            }
            sb.append(days).append("\n");
        }

        System.out.print(sb);
    }
    
}