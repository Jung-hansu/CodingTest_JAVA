import java.io.*;

public class Main {
    
    private static int readInt() throws IOException{
        int c, n = 0;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {
        int X = readInt(), K = readInt();
        long res = 0;

        for (int i = 0; K > 0; i++){
            if ((X & 1) == 0) {
                res |= (K & 1L) << i;
                K >>= 1;
            }
            X >>= 1;
        }
        System.out.println(res);
    }

}