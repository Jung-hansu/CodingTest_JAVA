import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Math.max(
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum(), 
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum())
        );
    }
}
