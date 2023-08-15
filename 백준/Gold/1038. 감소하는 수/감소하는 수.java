import java.io.*;

public class Main {
    private static int cnt = 0;
    private static int[] num;
    private static int getDigit(int n){
        int comb10 = 1;
        for (int i = 1; i <= 10; i++) {
            comb10 = comb10 * (11-i) / i;
            if (n <= comb10) return i;
            cnt += comb10;
            n -= comb10;
        }
        return -1;
    }
    private static void getSuccessor(int i){
        num[num.length - i]++;
        if (i == num.length) return;
        if (num[num.length - i] >= 9 || num[num.length - i] == num[num.length - i - 1]) {
            num[num.length - i] = (i == 1 ? 0 : num[num.length - i + 1] + 1);
            getSuccessor(i + 1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), digit = getDigit(N+1);

        if (digit < 0){
            System.out.println(-1);
            return;
        }
        num = new int[digit];
        for (int i = 0; i < num.length; i++) num[num.length-i-1] = i;
        while (cnt < N){
            getSuccessor(1);
            cnt++;
        }
        for (int n : num) System.out.print(n);
    }
}