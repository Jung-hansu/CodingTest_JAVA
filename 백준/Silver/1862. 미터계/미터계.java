import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int c, n = 0;

        while ((c = System.in.read()) > 31){
            n = n * 9 + ((c > '4' ? c - 1 : c) & 15);
        }
        System.out.println(n);
    }

}