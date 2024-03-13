import java.io.*;
import java.util.*;

public class Main {

    private static int gcd(int a, int b){
        int big = Math.max(a, b), small = Math.min(a, b);

        while (big % small > 0){
            small = big % (big = small);
        }
        return small;
    }

    private static int gcdAll(int[] arr, int start, int end){
        int res = arr[start];

        for (int i = start + 1; i < end; i++){
            res = gcd(res, arr[i]);
        }
        return res;
    }

    // l inclusive, r exclusive
    private static int getMaxGcd(int[] arr, int l, int r, int gcdSum){
        if (l == r - 1){
            return gcdSum + arr[l];
        }

        int m = (l + r) / 2;
        return Math.max(
                getMaxGcd(arr, m, r, gcdSum + gcdAll(arr, l, m)), 
                getMaxGcd(arr, l, m, gcdSum + gcdAll(arr, m, r))
        );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        //parsing
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxGcd(arr, 0, N, 0));
    }

}