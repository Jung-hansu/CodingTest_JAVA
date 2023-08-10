import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), nth;

        for (nth = 1; N > nth; nth++) N -= nth;
        if (nth%2 == 0) System.out.println(N + "/" + (nth-N+1));
        else System.out.println((nth-N+1) + "/" + N);
    }
}