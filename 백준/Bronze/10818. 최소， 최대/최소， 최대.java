import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (N-- > 0){
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        System.out.println(min+" "+max);
    }
}