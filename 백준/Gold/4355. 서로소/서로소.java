import java.io.*;
import java.util.*;

public class Main {
    private static int eulerPhi(int n){
        List<Integer> pFactors = new ArrayList<>();
        double tmp = n;

        for (int i = 2; i * i <= n; i++)
            if (n%i == 0){
                pFactors.add(i);
                while (n%i == 0) n /= i;
            }
        if (n > 1) pFactors.add(n);
        for (int p : pFactors) tmp *= (double)(p-1)/p;
        return (int)Math.round(tmp);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;

        while ((n = Integer.parseInt(br.readLine())) > 0)
            bw.write((n > 1 ? eulerPhi(n) : 0)+"\n");
        bw.close();
    }
}
