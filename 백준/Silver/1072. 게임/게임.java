import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), ans = 0;

        if (100*Y/X >= 99) System.out.println(-1);
        else{
            int l = 0, r = X+1;
            while (l < r){
                int mid = (l + r) / 2;
                if (100L*(Y+mid)/(X+mid) < 100L*Y/X+1)
                    l = mid+1;
                else
                    r = mid;
            }
            System.out.println(l<X+1 ? l : -1);
        }
    }
}
