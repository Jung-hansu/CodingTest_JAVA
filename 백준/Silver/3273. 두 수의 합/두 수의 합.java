import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = 0, r = Integer.parseInt(br.readLine()) - 1, ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[r+1];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        while (l < r) {
            if (arr[l] + arr[r] == x) ans++;
            if (arr[l] + arr[r] <= x) l++;
            else if (arr[l] + arr[r] > x) r--;
        }
        System.out.println(ans);
    }
}
