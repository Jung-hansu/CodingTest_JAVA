import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()), stick = 64, answer = 1;

        while (stick != X)
            if (stick/2 >= X) stick /= 2;
            else{
                X -= (stick /= 2);
                answer++;
            }
        System.out.println(answer);
    }
}