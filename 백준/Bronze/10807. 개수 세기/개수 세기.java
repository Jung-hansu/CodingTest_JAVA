import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[201];

        for (int i = 0; i < N; i++){
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }
        System.out.println(arr[Integer.parseInt(br.readLine()) + 100]);
    }

}