import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            int n = Integer.parseInt(br.readLine());
            if (n == 0 && !pq.isEmpty()) bw.write(pq.remove()+"\n");
            else if (n== 0) bw.write("0\n");
            else pq.add(n);
        }
        bw.close();
    }
}