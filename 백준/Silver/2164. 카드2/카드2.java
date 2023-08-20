import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) q.add(i);
        while (q.size() > 1){
            q.remove();
            q.add(q.remove());
        }
        System.out.println(q.remove());
    }
}