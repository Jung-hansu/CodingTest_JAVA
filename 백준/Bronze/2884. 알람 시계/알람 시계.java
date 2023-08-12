import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int HH = Integer.parseInt(st.nextToken()), MM = Integer.parseInt(st.nextToken());

        if (MM >= 45) System.out.println(HH+" "+(MM-45));
        else System.out.println((HH+23)%24+" "+(MM+15));
    }
}