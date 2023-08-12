import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) 
            bw.write(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()+"\n");
        bw.flush();
    }
}