import java.util.stream.IntStream;
class Solution {
    public int[] solution(int s, int e) {
        return IntStream.range(s, e+1).toArray();
    }
}