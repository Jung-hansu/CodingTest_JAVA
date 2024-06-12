import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

    private static class Number implements Comparable<Number>{
        int num;
        BigInteger digit;

        public Number(int num, BigInteger digit) {
            this.num = num;
            this.digit = digit;
        }

        @Override
        public int compareTo(Number n) {
            int compare = -BigInteger.valueOf(35 - this.num).multiply(this.digit)
                    .compareTo(BigInteger.valueOf(35 - n.num).multiply(n.digit));
            return compare == 0 ? n.num - this.num : compare;
        }
    }

    private static final int[][] digits = new int[50][36];
    private static final BigInteger THIRTY_SIX = BigInteger.valueOf(36);
    private static final BigInteger ZERO = BigInteger.ZERO;

    private static String trim0(String s){
        int beginIndex = 0;

        while (beginIndex < s.length() && s.charAt(beginIndex) == '0'){
            beginIndex++;
        }
        return beginIndex < s.length() ? s.substring(beginIndex) : "0";
    }

    private static int convertCharToInt(char c){
        return c <= '9' ? c & 15 : (c & 31) + 9;
    }

    private static char convertIntToChar(int n){
        return (char)(n <= 9 ? n + '0' : n - 10 + 'A');
    }

    private static String convertToDigit36(BigInteger num){
        StringBuilder sb = new StringBuilder();

        if (num.equals(ZERO)){
            return "0";
        }
        while (num.compareTo(ZERO) > 0){
            sb.append(convertIntToChar(num.mod(THIRTY_SIX).intValue()));
            num = num.divide(THIRTY_SIX);
        }
        return sb.reverse().toString();
    }

    private static String getMaxSum(BigInteger[] flattenDigits, int K){
        PriorityQueue<Number> pq = new PriorityQueue<>();
        BigInteger maxSum = ZERO;

        for (int i = 0; i < 36; i++){
            pq.add(new Number(i, flattenDigits[i]));
        }

        while (!pq.isEmpty()){
            Number number = pq.remove();
            maxSum = maxSum.add(BigInteger.valueOf(K-- > 0 ? 35 : number.num).multiply(number.digit));
        }

        return convertToDigit36(maxSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] flattenDigits = new BigInteger[36];
        int N = Integer.parseInt(br.readLine()), K;

        for (int i = 0; i < N; i++){
            String s = trim0(br.readLine());
            int len = s.length();
            for (int n = len - 1; n >= 0; n--){
                digits[len - n - 1][convertCharToInt(s.charAt(n))]++;
            }
        }
        K = Integer.parseInt(br.readLine());

        for (int j = 0; j < 36; j++){
            BigInteger num = ZERO;

            for (int i = 0; i < digits.length; i++){
                if (digits[i][j] > 0){
                    num = num.add(THIRTY_SIX.pow(i).multiply(BigInteger.valueOf(digits[i][j])));
                }
            }
            flattenDigits[j] = num;
        }

        System.out.println(getMaxSum(flattenDigits, K));
    }

}