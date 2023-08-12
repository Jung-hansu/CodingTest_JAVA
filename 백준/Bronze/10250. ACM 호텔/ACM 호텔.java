import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()),
                W = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken());
            bw.write((N%H>0?N%H:H)*100+(int)Math.ceil((double)N/H)+"\n");
        }
        bw.flush();
    }
}