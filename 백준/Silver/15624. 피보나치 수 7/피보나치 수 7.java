import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    private static long[] arr;
    private static final int P = 1000000007;
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
    private static long getFib(BigInteger N){
        BitSet bs = new BitSet();

        arr = new long[]{0, 1};
        for (int i = 0; !N.equals(BigInteger.ZERO); i++, N = N.shiftRight(1))
            if (N.mod(BigInteger.TWO).equals(BigInteger.ONE))
                bs.set(i);
        int highestBit = bs.length()-1;
        for (int i = highestBit; i >= 0; i--) {
            if (i < highestBit && bs.get(i)) getNextFib();
            if (i > 0) get2nFib();
        }
        return arr[1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        System.out.println(getFib(N));
    }
}
