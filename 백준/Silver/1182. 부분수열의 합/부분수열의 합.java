import java.io.*;
import java.util.*;

public class Main {
    private static int answer = 0;
    private static void bt(int[] nums, int S, int sum, int i, int len){
        if (i == nums.length) {
            if (len > 0 && sum == S) answer++;
            return;
        }
        bt(nums, S, sum + nums[i], i+1, len+1);
        bt(nums, S, sum, i+1, len);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        bt(nums, S, 0, 0, 0);
        System.out.println(answer);
    }
}