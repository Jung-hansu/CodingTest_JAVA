import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp, max = 0, maxIdx = 0;

        for (int i = 1; i <= 9; i++)
            if ((tmp = Integer.parseInt(br.readLine())) > max){
                max = tmp;
                maxIdx = i;
            }
        System.out.println(max);
        System.out.println(maxIdx);
    }
}