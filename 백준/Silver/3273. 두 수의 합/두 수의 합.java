import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = 0, r = Integer.parseInt(br.readLine()) - 1, ans = 0;
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .sorted()
                          .toArray();
        int x = Integer.parseInt(br.readLine());
        while (l < r){
            if (arr[l] + arr[r] == x) ans++;
            if (arr[l] + arr[r] <= x) l++;
            else if (arr[l] + arr[r] > x) r--;
        }
        System.out.println(ans);
    }
}
