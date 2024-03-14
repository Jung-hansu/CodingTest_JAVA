import java.io.*;

public class Main {

    private static int readInt() throws IOException {
        int c, n = 0;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static long ceilDiv(long x, long y){
        final long q = x / y;
        return ((x ^ y) == 0 || q * y == x) ? q : q + 1;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        long heroAtk = readInt(), heroHp = 1, maxHp = 1;

        for (int i = 0; i < N; i++){
            int t = readInt(), atk = readInt(), hp = readInt();

            if (t == 1){
                heroHp += (ceilDiv(hp, heroAtk) - 1) * atk;
                maxHp = Math.max(maxHp, heroHp);
            }
            else {
                heroHp = Math.max(heroHp - hp, 1);
                heroAtk += atk;
            }
        }

        System.out.println(maxHp);
    }

}