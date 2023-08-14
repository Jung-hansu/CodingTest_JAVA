import java.io.*;

public class Main {
    private static int bunhaeSum(int n){
        int res = n;
        while (n > 0){
            res += n % 10;
            n /= 10;
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
            if (bunhaeSum(i) == N){
                System.out.println(i);
                return;
            }
        System.out.println("0");
    }
}