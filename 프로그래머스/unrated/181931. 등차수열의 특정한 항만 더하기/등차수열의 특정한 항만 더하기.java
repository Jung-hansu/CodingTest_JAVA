import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).filter(i->included[i]).map(i->a+i*d).sum();
    }
}