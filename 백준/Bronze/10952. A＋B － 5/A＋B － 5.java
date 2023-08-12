import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        
        while (!(s = br.readLine()).equals("0 0"))
            bw.write(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sum()+"\n");
        bw.flush();
    }
}