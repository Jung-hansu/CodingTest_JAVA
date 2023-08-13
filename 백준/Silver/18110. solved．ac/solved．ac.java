import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), cut = (int)Math.round((double)N*15/100), sum = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int n : Arrays.copyOfRange(arr, cut, arr.length-cut)) sum += n;
        System.out.println((int)Math.round((double)sum/(N-2*cut)));
    }
}