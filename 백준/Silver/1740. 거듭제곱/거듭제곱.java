import java.io.*;

public class Main {
    private static long terToDec(String ternary){
        long res = 0;
        for (int i = 0; i < ternary.length(); i++)
            res = 3 * res + ternary.charAt(i)-'0';
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        System.out.println(terToDec(Long.toBinaryString(N)));
    }
}
