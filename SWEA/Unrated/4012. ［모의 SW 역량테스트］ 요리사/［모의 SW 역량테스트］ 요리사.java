import java.io.*;
import java.util.*;

public class Solution {

    private static BitSet comb = new BitSet();
    private static int N, minDiff;
    private static int[][] synergy;

    private static void combine(int depth, int num){
        if (depth >= N / 2) {
            int diff = 0;

            for (int i = 0; i < N - 1; i++){
                for (int j = i + 1; j < N; j++){
                    if (comb.get(i) ^ comb.get(j)) {
                        continue;
                    }
                    //i, j가 같은 집합에 있을 때만 차이 계산
                    diff += (synergy[i][j] + synergy[j][i]) * (comb.get(i) ? 1 : -1);
                }
            }
            minDiff = Math.min(minDiff, Math.abs(diff));
            return;
        }

        //N가지 중 N/2가지를 고르는 조합 구하기
        for (int n = num; n <= N / 2 + depth; n++){
            comb.set(n);
            combine(depth + 1, n + 1);
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
            //0을 선택하지 않는 경우만 세서 중복 예방
            combine(0, 1);
            sb.append('#').append(tc).append(' ').append(minDiff).append('\n');
        }
        System.out.println(sb);
    }

}