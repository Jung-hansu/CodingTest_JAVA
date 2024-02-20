import java.io.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;
        int flag = 1;

        while((c = System.in.read()) > 32) {
            if (c == '-') {
                flag = -1;
                continue;
            }
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return flag * n;
    }

    private static int binarySearch(int[] arr, int key, int size){
        int l = 0, r = size;

        while (l < r){
            int m = (l + r) / 2;

            if (arr[m] >= key){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] increase = new int[N];
        int size = 1;

        increase[0] = readInt();
        for (int i = 1; i < N; i++){
            int num = readInt();
            int idx = binarySearch(increase, num, size);
            increase[idx] = num;
            size = Math.max(size, idx + 1);
        }
        System.out.println(size);
    }

}