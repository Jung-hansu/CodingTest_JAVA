import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = 0;

        for (int i = 0; i < 5; i++) tmp += (int)Math.pow(Integer.parseInt(st.nextToken()),2);
        System.out.println(tmp%10);
    }
}