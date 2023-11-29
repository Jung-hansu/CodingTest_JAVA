import java.io.*;
import java.util.*;

public class Main {
    private static long binarySearch(int[] trees, int M){
        long l = 0, r = trees[trees.length - 1];

        while(l <= r){
            long m = (l + r) / 2, total = 0;

            for (int tree : trees)
                if (tree > m) total += tree - m;
            if (total < M) r = m - 1;
            else l = m + 1;
        }
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];

        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);
        System.out.println(binarySearch(trees, M));
    }
}
