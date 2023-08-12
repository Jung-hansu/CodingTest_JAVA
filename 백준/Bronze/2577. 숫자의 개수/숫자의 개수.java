import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] nums = new int[10];

        for (; n > 0; n /= 10) nums[n%10]++;
        for (int i : nums) System.out.println(i);
    }
}