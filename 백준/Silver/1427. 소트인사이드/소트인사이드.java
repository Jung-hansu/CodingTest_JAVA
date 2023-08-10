import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();

        Arrays.sort(num);
        for (int i = num.length-1; i >= 0; i--) System.out.print(num[i]);
    }
}