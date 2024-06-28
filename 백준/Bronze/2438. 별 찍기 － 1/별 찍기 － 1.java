import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c, n = 0;
        
        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++){
                sb.append("*");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}