import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
        Arrays.stream(br.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .filter(i -> i<X)
              .forEach(o-> System.out.print(o+" "));
    }
}