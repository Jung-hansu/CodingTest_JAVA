import java.io.*;
import java.util.*;

public class Main {

    private static int[] combine(int[] arr1, int[] arr2){
        int[] ret = new int[arr1.length * arr2.length];
        int idx = 0;

        for (int n1 : arr1) {
            for (int n2 : arr2) {
                ret[idx++] = n1 + n2;
            }
        }
        return ret;
    }

    private static int binarySearch(int[] arr, int key){
        int idx = Arrays.binarySearch(arr, key);
        return (idx < 0) ? - idx - 1 : idx;
    }

    private static int compare(int x, int y, int K){
        return 2L * K - x - y > 0 ? Math.max(x, y) : Math.min(x, y);
    }

    private static int find(int[] comb1, int[] comb2, int K) {
        int res = Integer.MAX_VALUE;

        Arrays.sort(comb2);
        for (int n1 : comb1) {
            int minSum, idx = binarySearch(comb2, K - n1);

            if (idx == 0){
                minSum = n1 + comb2[idx];
            } else if (idx == comb2.length){
                minSum = n1 + comb2[idx - 1];
            } else if (n1 + comb2[idx] != K){
                minSum = compare(n1 + comb2[idx - 1], n1 + comb2[idx], K);
            } else {
                return K;
            }

            res = compare(res, minSum, K);
        }
        return res;
    }

    private static int readInt() throws IOException {
        int c, n = 0;
        
        while ((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int K = readInt(), N = readInt();
            int[][] classes = new int[4][N];

            for (int[] cls : classes) {
                for (int i = 0; i < N; i++) {
                    cls[i] = readInt();
                }
            }

            int[] comb1 = combine(classes[0], classes[1]);
            int[] comb2 = combine(classes[2], classes[3]);

            sb.append(find(comb1, comb2, K)).append('\n');
        }
        System.out.print(sb);
    }
}