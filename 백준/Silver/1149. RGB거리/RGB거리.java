import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][];
        
        for (int i = 0; i < n; i++)
            rgb[i] = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        for (int i = 1; i < n; i++){
            rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
            rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
        }
        System.out.println(Arrays.stream(rgb[n-1]).min().getAsInt());
    }
}