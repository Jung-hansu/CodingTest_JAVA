import java.io.*;
import java.util.*;

public class Main {

    private static int getNextDuckIdx(int[] duck, int time){
        int idx = Arrays.binarySearch(duck, time);

        if (idx < 0){
            idx = -idx - 1;
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] duck = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            duck[i] = Integer.parseInt(st.nextToken());
        }

        int time = duck[0], clapCnt = 0;
        while(time <= duck[N - 1]){
            time += K + 1;
            clapCnt++;
            int nextDuckIdx = getNextDuckIdx(duck, time);
            
            if (nextDuckIdx < N){
                time = duck[nextDuckIdx];
            }
        }
        System.out.println(clapCnt);
    }

}