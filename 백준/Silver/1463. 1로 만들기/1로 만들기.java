import java.io.*;
import java.util.*;

public class Main {
    private static int bfs(int N){
        Queue<Integer> q = new LinkedList<>();
        int res = 0;

        q.add(N);
    a:  while(!q.isEmpty()){
            res++;
            for (int i = q.size(); i > 0; i--) {
                int tmp = q.remove();

                if (tmp % 3 == 0) {
                    if (tmp / 3 == 1) break a;
                    q.add(tmp/3);}
                if (tmp % 2 == 0){
                    if (tmp / 2 == 1) break a;
                    q.add(tmp/2);}
                if (tmp > 1) {
                    if (tmp == 2) break a;
                    q.add(tmp - 1);}
            }}
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(N==1?0:bfs(N));
    }
}
