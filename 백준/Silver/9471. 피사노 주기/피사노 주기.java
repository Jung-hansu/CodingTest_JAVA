import java.io.*;
import java.util.*;
// 0 1
public class Main {

    private static int k(int n){
        int[] arr = {1, 1};
        int i = 2;

        while (arr[i % 2] != 0 || arr[(i + 1) % 2] != 1){
            arr[(i + 1) % 2] = (arr[0] + arr[1]) % n;
            i++;
        }
        return i;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int M = Integer.parseInt(st.nextToken());
            sb.append(tc).append(" ").append(k(M)).append("\n");
        }
        System.out.print(sb);
    }

}