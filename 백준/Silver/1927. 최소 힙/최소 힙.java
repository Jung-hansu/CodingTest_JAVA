import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            int op = Integer.parseInt(br.readLine());
            if (op > 0) pq.add(op);
            else bw.write(pq.isEmpty() ? "0\n" : pq.remove()+"\n");
        }
        bw.close();
    }
}