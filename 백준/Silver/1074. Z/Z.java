import java.io.*;
import java.util.*;

public class Main {
    private static int recursive(int N, int r, int c, int res){
        if (N == 0) return res;
        int area = r/(1<<(N-1))*2+c/(1<<(N-1));
        return recursive(N-1, r-(area/2)*(1<<(N-1)), c-(area%2)*(1<<(N-1)), res+area*(1<<(2*N-2)));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
            r = Integer.parseInt(st.nextToken()),
            c = Integer.parseInt(st.nextToken());
        System.out.println(recursive(N, r, c, 0));
    }
}
