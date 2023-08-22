import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i;

        for (i = N/5; i >= 0 && (N-5*i)%3 > 0; i--);
        if (i < 0) System.out.println(i);
        else System.out.println(i+(N-5*i)/3);
    }
}