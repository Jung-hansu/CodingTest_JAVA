import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i, cnt = 0;

        for (i = 666; cnt < N; i++)
            if (String.valueOf(i).contains("666"))
                cnt++;
        System.out.println(i - 1);
    }
}
