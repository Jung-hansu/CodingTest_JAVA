import java.io.*;
import java.util.*;

public class Main {
    private static Set<Integer> nums = new HashSet<>();
    private static String nextTmp(String tmp){
        if (tmp.equals("9".repeat(tmp.length())))
            return "0".repeat(tmp.length()+1);

        long tmpN = Long.parseLong(tmp)+1;
        return "0".repeat(tmp.length()-String.valueOf(tmpN).length())+tmpN;
    }
    private static long solution(String N){
        long res = Long.parseLong(N), cnt = 0;
        String tmp = "0";

        for (int num : nums) {
            cnt++;
            if (res % num != 0) break;
            if (cnt == nums.size()) return res;
        }

        while (true){
            res = Long.parseLong(N + tmp);
            cnt = 0;
            for (int num : nums) {
                cnt++;
                if (res % num != 0) break;
                if (cnt == nums.size()) return res;
            }
            tmp = nextTmp(tmp);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        for (int i = 0; i < N.length(); i++)
            if (N.charAt(i) != '0')
                nums.add(N.charAt(i) - '0');

        System.out.println(solution(N));
    }
}
