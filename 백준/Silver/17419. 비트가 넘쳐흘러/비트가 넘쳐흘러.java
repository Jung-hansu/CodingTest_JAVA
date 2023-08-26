import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), res = 0;
        BigInteger bi = new BigInteger(String.valueOf(Integer.parseInt(br.readLine(),2)));

        while (!bi.equals(new BigInteger("0"))){
            bi = bi.subtract(bi.and(bi.not().add(new BigInteger("1"))));
            res++;
        }
        System.out.println(res);
    }
}