import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BigInteger node = BigInteger.ONE;
        int stars = 0;

        if (s.equals("*")){
            System.out.println(6);
            return;
        }
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'L') node = node.multiply(BigInteger.TWO);
            else if (s.charAt(i) == 'R') {
                node = node.multiply(BigInteger.TWO).add(BigInteger.ONE);
                node = node.add(BigInteger.valueOf(3).pow(stars)).subtract(BigInteger.ONE);
            }
            else if (s.charAt(i) == '*') {
                node = node.multiply(BigInteger.valueOf(5)).add(BigInteger.ONE);
                node = node.add(BigInteger.valueOf(3).pow(stars)).subtract(BigInteger.ONE);
                stars++;
            }
        }
        System.out.println(node);
    }
}
