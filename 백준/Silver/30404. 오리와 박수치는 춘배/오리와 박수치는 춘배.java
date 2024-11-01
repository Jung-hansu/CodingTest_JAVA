import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int clapCnt = 0, time = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int curDuck = Integer.parseInt(st.nextToken());

            if (time < curDuck){
                time = curDuck + K;
                clapCnt++;
            }
        }
        System.out.println(clapCnt);
    }

}