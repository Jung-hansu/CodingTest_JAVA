import java.util.*;

class Solution {
    private static BitSet primes = new BitSet();
    private static void setPrime(){
        primes.set(0, 2);
        for (int i = 2; i <= 1000000; i++)
            for (int j = i * 2; j <= 1000000; j += i)
                primes.set(j);
    }
    private int getX(int _n){
        int i = 2;

        while (_n % i > 0)
            i = primes.nextClearBit(i + 1);
        return i;
    }
    public int solution(int n) {
        if (n % 2 == 1) return 2;
        setPrime();
        if (!primes.get(n-1)) return n-1;
        return getX(n-1);
    }
}