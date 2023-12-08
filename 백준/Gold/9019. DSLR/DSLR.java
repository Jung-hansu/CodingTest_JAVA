import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int N;
        String op;
        Node(int N, String op){this.N=N; this.op = op;}
    }
    private static int D(int N){return 2 * N % 10000;}
    private static int S(int N){return (N + 9999) % 10000;}
    private static int L(int N){return N / 1000 + N % 1000 * 10;}
    private static int R(int N){return N % 10 * 1000 + N / 10;}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            Deque<Node> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());

            q.add(new Node(from, ""));
            while(!q.isEmpty()){
                Node tmp = q.remove();
                int tmp2;

                if (tmp.N == to){
                    bw.write(tmp.op+"\n");
                    break;
                }
                if (!set.contains(tmp2=D(tmp.N))){
                    set.add(tmp2);
                    q.add(new Node(D(tmp.N), tmp.op+"D"));
                }
                if (!set.contains(tmp2=S(tmp.N))) {
                    set.add(tmp2);
                    q.add(new Node(S(tmp.N), tmp.op + "S"));
                }
                if (!set.contains(tmp2=L(tmp.N))) {
                    set.add(tmp2);
                    q.add(new Node(L(tmp.N), tmp.op + "L"));
                }
                if (!set.contains(tmp2=R(tmp.N))) {
                    set.add(tmp2);
                    q.add(new Node(R(tmp.N), tmp.op + "R"));
                }
            }
        }
        bw.close();
    }
}
