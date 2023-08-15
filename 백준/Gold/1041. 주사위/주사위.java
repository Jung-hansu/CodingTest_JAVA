import java.io.*;
import java.util.*;

public class Main {
    private static long[] getMinSum(long[] dice){
        long[] res = new long[3];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++)
            min = Math.min(min, dice[i]);
        res[0] = min;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++)
            for (int j = i+1; j < 6; j++)
                if (i+j != 5)
                    min = Math.min(min, dice[i]+dice[j]);
        res[1] = min;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++)
            for (int j = i+1; j < 5; j++)
                for (int k = j+1; k < 6; k++)
                    if (i+j != 5 && i+k != 5 && j+k != 5)
                        min = Math.min(min, dice[i]+dice[j]+dice[k]);
        res[2] = min;
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] minSum, dice = new long[6];
        long[] face = new long[]{(N-2)*(N-2)*5 + (N-2)*4, (N-2)*8 + 4, 4};

        for (int i = 0; i < 6; i++) dice[i] = Long.parseLong(st.nextToken());
        if (N == 1){
            long max = 0, sum = 0;
            for (long n : dice){
                sum += n;
                max = Math.max(max, n);
            }
            System.out.println(sum-max);
            return;
        }
        minSum = getMinSum(dice);
        System.out.println(face[0]*minSum[0] + face[1]*minSum[1] + face[2]*minSum[2]);
    }
}