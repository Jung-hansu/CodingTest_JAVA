import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        for (int i = 1; i <= N; i++) System.out.println("*".repeat(i));
    }
}