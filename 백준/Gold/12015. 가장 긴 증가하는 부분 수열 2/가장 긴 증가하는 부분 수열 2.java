import java.io.*;
import java.util.Arrays;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;

        while((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] increase = new int[N];
        int size = 1;

        increase[0] = readInt();
        for (int i = 1; i < N; i++){
            int num = readInt();
            int idx = Arrays.binarySearch(increase, 0, size, num);
            if (idx < 0) idx = - idx - 1;
            increase[idx] = num;
            size = Math.max(size, idx + 1);
        }
        System.out.println(size);
    }

}