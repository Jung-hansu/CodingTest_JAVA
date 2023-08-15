import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i;

        for (i = 0; i < N; i++) System.out.println(" ".repeat(i) + "*".repeat(2*(N-i)-1));
        i--;
        while (i-- > 0) System.out.println(" ".repeat(i) + "*".repeat(2*(N-i)-1));
    }
}