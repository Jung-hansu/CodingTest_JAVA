import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        System.out.print(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).min().getAsInt()+" ");
        System.out.print(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).max().getAsInt());
    }
}