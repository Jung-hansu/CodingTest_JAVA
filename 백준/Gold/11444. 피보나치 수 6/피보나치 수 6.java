import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    private static long[] arr = new long[]{0, 1};
    private static final int P = 1000000007;
    // F(2n)   = F(n)^2 + 2F(n)F(n-1)
    // F(2n-1) = F(n)^2 + F(n-1)^2
    private static void get2nFib(){
        long a = arr[0], b = arr[1];
        arr[0] = (a*a%P + b*b%P) % P;
        arr[1] = (2*a*b%P + b*b%P) % P;
    }
    private static void getNextFib(){
        long a = arr[0], b = arr[1];
        arr[0] = b;
        arr[1] = (a+b) % P;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BitSet bs = new BitSet();

        // Binarization N
        for (int i = 0; !N.equals(BigInteger.ZERO); i++, N = N.shiftRight(1))
            if (N.mod(BigInteger.TWO).equals(BigInteger.ONE))
                bs.set(i);
        int highestBit = bs.length()-1;
        for (int i = highestBit; i >= 0; i--) {
            if (i < highestBit && bs.get(i)) getNextFib();
            if (i > 0) get2nFib();
        }
        System.out.println(arr[1]);
    }
}
