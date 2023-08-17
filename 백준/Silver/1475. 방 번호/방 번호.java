import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] nums = new int[10];
        int ans = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '6' || s.charAt(i) == '9')
                if (nums[6] <= nums[9]) nums[6]++;
                else nums[9]++;
            else nums[s.charAt(i)-'0']++;
        for (int n : nums) ans = Math.max(ans, n);
        System.out.println(ans);
    }
}
