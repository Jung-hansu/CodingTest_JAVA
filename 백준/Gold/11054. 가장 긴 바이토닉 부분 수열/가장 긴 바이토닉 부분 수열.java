import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;
        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    private static int binarySearch(int[] arr, int key, int size){
        int l = 0, r = size;

        while (l < r){
            int m = (l + r) / 2;

            if (arr[m] >= key){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();

        /** input arr */
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = readInt();
        }

        /** 최장 증가 부분수열 기록 */
        int[] increase = new int[N];
        int[] dp_LIS = new int[N];      //Longest Increasing Subsequence 길이
        int size = 1;
        increase[0] = arr[0];
        dp_LIS[0] = 1;
        for (int i = 1; i < N; i++){
            int idx = binarySearch(increase, arr[i], size);
            increase[idx] = arr[i];         //DP(LIS 기록)
            dp_LIS[i] = idx + 1;            //해당 인덱스(i)가 포함되는 LIS 최대 길이(idx+1) 기록
            size = Math.max(size, idx + 1); //이분탐색 범위 업데이트
        }

        /** 최장 감소 부분수열(역방향) 기록*/
        int[] decrease = new int[N];
        int[] dp_LDS = new int[N];      //Longest Decreasing Subsequence 길이
        size = 1;
        decrease[0] = arr[N - 1];
        dp_LDS[0] = 1;
        for (int i = 1; i < N; i++){
            int idx = binarySearch(decrease, arr[N - i - 1], size);
            decrease[idx] = arr[N - i - 1]; //DP(LDS 기록)
            dp_LDS[N - i - 1] = idx + 1;    //해당 인덱스(N-i-1)가 포함되는 LDS 최대 길이(idx+1) 기록
            size = Math.max(size, idx + 1); //이분탐색 범위 업데이트
        }

        /** 최장 바이토닉 부분수열 길이 구하기 */
        int maxLen = 0;
        for (int i = 0; i < N; i++){
            //i: 증가에서 감소로 바뀌는 부분
            maxLen = Math.max(maxLen, dp_LIS[i] + dp_LDS[i] - 1);
        }
        System.out.println(maxLen);
    }

}