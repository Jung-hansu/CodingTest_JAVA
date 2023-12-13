import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE, res = 0;

        for (int i = 0; i < 3; i++) min = Math.min(min, Integer.parseInt(br.readLine()));
        res += min;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) min = Math.min(min, Integer.parseInt(br.readLine()));
        System.out.println(res+min-50);
    }
}
