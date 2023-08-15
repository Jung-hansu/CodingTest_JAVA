import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N-1; i >= 0; i--)
            System.out.println(" ".repeat(N-i-1) + "*".repeat(2*i+1));
    }
}