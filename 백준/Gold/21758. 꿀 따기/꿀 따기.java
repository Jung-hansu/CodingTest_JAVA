import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] places = new int[N + 1];
        int[] cumulativeSum = new int[N + 1];
        int bee, totalHoney1, totalHoney2, totalHoney3;
        int maxBeeHoney, maxHoney = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            places[i] = Integer.parseInt(st.nextToken());
            cumulativeSum[i] = cumulativeSum[i - 1] + places[i];
            maxHoney = Math.max(maxHoney, places[i]);
        }

        // 벌1, 벌2, 꿀통 중 둘은 항상 양 끝에 있어야 함
        // case 1: 꿀통이 오른쪽 끝에 있는 경우
        totalHoney1 = cumulativeSum[N] - places[1];
        maxBeeHoney = 0;
        for (bee = 2; bee < N; bee++){
            int bee2Honey = cumulativeSum[N] - cumulativeSum[bee] - places[bee];
            maxBeeHoney = Math.max(maxBeeHoney, bee2Honey);
        }
        totalHoney1 += maxBeeHoney;

        // case 2: 꿀통이 왼쪽 끝에 있는 경우
        totalHoney2 = cumulativeSum[N] - places[N];
        maxBeeHoney = 0;
        for (bee = 2; bee < N; bee++){
            int bee2Honey = cumulativeSum[bee - 1] - places[bee];
            maxBeeHoney = Math.max(maxBeeHoney, bee2Honey);
        }
        totalHoney2 += maxBeeHoney;

        // case 3: 벌이 양쪽 끝에 있는 경우
        totalHoney3 = cumulativeSum[N] - places[1] - places[N] + maxHoney;

        System.out.println(Math.max(Math.max(totalHoney1, totalHoney2), totalHoney3));
    }

}