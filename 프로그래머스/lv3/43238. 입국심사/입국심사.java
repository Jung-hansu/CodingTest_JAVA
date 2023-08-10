import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long l = 0, r = n * (long)Arrays.stream(times).max().getAsInt();
        while (l <= r){
            long sum = 0, mid = (l + r)/2;
            for (int time : times) sum += mid/time;

            if (sum >= n)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}