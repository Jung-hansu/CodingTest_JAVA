import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int tmp = 0;
        
        for (int i = 0; i < s.length(); i++)
            tmp = (10*tmp + (s.charAt(i)-'0')) % 20000303;
        System.out.println(tmp);
    }
}
