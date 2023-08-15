import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), kim = Integer.parseInt(st.nextToken()),
            lim = Integer.parseInt(st.nextToken()), ans = 0;

        while (kim != lim){
            kim = (kim-1)/2+1;
            lim = (lim-1)/2+1;
            ans++;
        }
        System.out.println(ans);
    }
}