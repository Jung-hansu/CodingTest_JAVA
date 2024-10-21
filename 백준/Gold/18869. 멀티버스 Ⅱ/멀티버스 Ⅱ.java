import java.io.*;
import java.util.*;

public class Main {

    private static class Pair implements Comparable<Pair>{
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p){
            if (this.val == p.val){
                this.idx = p.idx = -1;
            }
            return this.val - p.val;
        }

        public static boolean equals(Pair[] pairs1, Pair[] pairs2){
            for (int i = 0; i < pairs1.length; i++){
                if (pairs1[i].idx != pairs2[i].idx){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Pair[][] universes = new Pair[M][N];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                int planet = Integer.parseInt(st.nextToken());
                universes[i][j] = new Pair(planet, j);
            }
            Arrays.sort(universes[i]);
        }

        BitSet check = new BitSet();
        int pairs = 0;
        for (int i = 0; i < M; i++){
            if (check.get(i)){
                continue;
            }
            int cnt = 1;
            check.set(i);
            for (int j = i + 1; j < M; j++){
                if (!check.get(j) && Pair.equals(universes[i], universes[j])){
                    check.set(j);
                    cnt++;
                }
            }
            pairs += cnt * (cnt - 1) / 2;
        }

        System.out.println(pairs);
    }

}