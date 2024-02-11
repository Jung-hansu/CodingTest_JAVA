import java.io.*;
import java.util.*;

public class Solution {

    private static BitSet comb = new BitSet();
    private static int N, minDiff;
    private static int[][] synergy;

    private static void combine(int idx, int num){
        if (idx >= N / 2) {
            int diff = 0;

            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    if (comb.get(i) ^ comb.get(j)) {
                        continue;
                    }
                    //i, j가 같은 집합에 있을 때만 계산
                    //1 집합이면 +, 0 집합이면 -하여 절댓값 구함 
                    diff += (synergy[i][j] + synergy[j][i]) * (comb.get(i) ? 1 : -1);
                }
            }
            minDiff = Math.min(minDiff, Math.abs(diff));
            return;
        }

        //N가지 중 N/2가지를 고르는 조합 구하기
        for (int n = num; n <= N / 2 + idx; n++){
            comb.set(n);
            combine(idx + 1, n + 1);
            comb.clear(n);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            //init
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            minDiff = Integer.MAX_VALUE;

            //parsing
            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //run
            combine(0, 0);
            sb.append('#').append(tc).append(' ').append(minDiff).append('\n');
        }
        System.out.println(sb);
    }

}