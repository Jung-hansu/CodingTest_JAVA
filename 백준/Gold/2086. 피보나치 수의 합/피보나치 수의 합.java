import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    private static long[] arr;
    private static final int M = 1000000000;
    private static void get2nFib(){
        long a = arr[0], b = arr[1];
        arr[0] = (a*a%M + b*b%M) % M;
        arr[1] = (2*a*b%M + b*b%M) % M;
    }
    private static void getNextFib(){
        long a = arr[0], b = arr[1];
        arr[0] = b;
        arr[1] = (a+b) % M;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(st.nextToken()), B = new BigInteger(st.nextToken());

        System.out.println((getFib(B.add(BigInteger.TWO)) - getFib(A.add(BigInteger.ONE)) + M) % M);
    }
}
